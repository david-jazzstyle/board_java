package com.david.dao;

import com.david.domain.BoardVO;

import java.util.List;

/**
 * Created by David on 2017-08-27.
 */
public interface BoardDao {
    public List<BoardVO> boardList();
}
