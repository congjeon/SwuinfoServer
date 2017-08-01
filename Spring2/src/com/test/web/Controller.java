package com.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.web.bean.BoardBean;
import com.test.web.bean.MemberBean;
import com.test.web.bean.TestBean;
import com.test.web.dao.BoardDao;
import com.test.web.dao.MemberDao;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BoardDao boardDao ;
	
	@RequestMapping("/hello")
	public String helloword(String id,String pw) {
		// 데이터가 온당 
		System.out.println("id : "+id+", pw : "+pw);
		
		return "HelloWorld";
	}
	
/*	@RequestMapping("/hello2")
	public String test2(TestBean tBean) {
		System.out.println("id : "+tBean.getId());
		
	MemberBean memberBean =memberDao.selectMember(memberBean bean);
		System.out.println("USER_ID: "+memberBean.getUserId());
		System.out.println("USER_PW: "+memberBean.getUserPw());
		System.out.println("NAME: "+memberBean.getName());
		System.out.println("HP: "+memberBean.getHp());
		
		return "HelloWorld";
	}
	*/
	@RequestMapping("/board")
	public String test3(BoardBean bBean) {
		
		BoardBean boardBean =boardDao.selectBoard(bBean);
		System.out.println("USER_ID: "+boardBean.getUserId());
		System.out.println("CONTENT: "+boardBean.getContext());
		System.out.println("ID: "+boardBean.getId());
		System.out.println("TITLE: "+boardBean.getTitle());

		return "Hello World";
	}

}
