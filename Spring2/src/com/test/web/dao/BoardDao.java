package com.test.web.dao;

import java.util.List;

import com.test.web.bean.BoardBean;

public interface BoardDao {
	public BoardBean selectBoard(BoardBean bBean);
	public List<BoardBean> selectBoardList();
	public int insertBoard(BoardBean bBean);
	public int updateBoard(BoardBean bBean);
	public int deleteBoard(BoardBean bBean);
}
