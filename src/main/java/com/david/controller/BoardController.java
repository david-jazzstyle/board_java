package com.david.controller;

import com.david.dao.BoardDao;
import com.david.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by David on 2017-08-27.
 */
@Controller
public class BoardController {

    @Autowired
    private BoardDao boardDao;

    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public ModelAndView board() {
        List<BoardVO> board = boardDao.boardList();

        Map<String, Object> result = new HashMap<>();
        result.put("boardList", board);

        return new ModelAndView("board/index", result);
    }
}
