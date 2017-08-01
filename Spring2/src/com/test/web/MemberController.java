package com.test.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.bean.MemberBean;
import com.test.web.dao.MemberDao;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("/rest/loginProc")
	@ResponseBody
	public Map<String, Object> loginProc(MemberBean mBean){
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		try {
		
			MemberBean resBean=memberDao.loginProc(mBean);
			
			if(resBean==null) {
				resMap.put("result", "fail");
				resMap.put("resultMsg", "해당하는 유저가 없습니다. \n 아이디와 비밀번호를 확인해주세요.");
			}else {
				resMap.put("result", "ok");
				resMap.put("resultMsg", "로그인 성공");
				resMap.put("memberBean", resBean);
			}
			
		resMap.put("result", "ok");
		resMap.put("memberBean", resBean);
		}catch(Exception e){
			e.printStackTrace();
			resMap.put("result","fail");
		}
		return resMap;
	}
	
	@RequestMapping("/rest/joinProc")
	@ResponseBody
	public Map<String, Object> insertMember(MemberBean mBean){
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		resMap.put("result","fail");
		
		try {
			
			int resVal=memberDao.insertMember(mBean);
			if(resVal>0) {
				resMap.put("result", "ok");
			}
		}
			catch(DuplicateKeyException dke) {
				resMap.put("resultMsg", "이미 존재하는 USER_ID입니다");
			}
		catch(Exception e){
			e.printStackTrace();
			resMap.put("resultMsg",e.getMessage());
		}
		return resMap;
	}
}
