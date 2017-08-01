package com.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.bean.BoardBean;

import com.test.web.dao.BoardDao;

@Controller
public class RESTController2 {
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("/rest/selectBoard")
	@ResponseBody
	public Map<String, Object> selectBoard(BoardBean bBean){
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		try {
		
		BoardBean boBean=boardDao.selectBoard(bBean);
			
		resMap.put("result", "ok");
		resMap.put("boardBean", boBean);
		}catch(Exception e){
			e.printStackTrace();
			resMap.put("result","fail");
		}
		return resMap;
	}
	
	@RequestMapping("/rest/selectBoardList")
	@ResponseBody
	public Map<String, Object> selectboardList(){
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		try {
		
			List<BoardBean> list=boardDao.selectBoardList();
			
		resMap.put("result", "ok");
		resMap.put("memberBean", list);
		}catch(Exception e){
			e.printStackTrace();
			resMap.put("result","fail");
		}
		return resMap;
	}
	
	// db -->bean--->json
		@RequestMapping("/rest/insertBoard")
		@ResponseBody
		public Map<String, Object> insertMember(BoardBean bBean){
			// memberBean의로 get값을 받음
			
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("result","fail");
			
			try {
			
				int resVal=boardDao.insertBoard(bBean);
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
		
		@RequestMapping("/rest/updateBoard")
		@ResponseBody
		public Map<String, Object> updateBoard(BoardBean bBean){
			// memberBean의로 get값을 받음
			
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("result","fail");
			
			try {
			
				int resVal=boardDao.updateBoard(bBean);
				if(resVal>0) {
					resMap.put("result", "ok");
				}
				else {
					resMap.put("resultMsg", "존재하지 않는 아이디 입니다.");
				}
			}
			catch(Exception e){
				e.printStackTrace();
				resMap.put("resultMsg",e.getMessage());
			}
			return resMap;
		}
		
		@RequestMapping("/rest/deleteMemberBoard")
		@ResponseBody
		public Map<String, Object> deleteBoard(BoardBean bBean){
			// memberBean의로 get값을 받음
			
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("result","fail");
			
			try {
			
				int resVal=boardDao.deleteBoard(bBean);
				if(resVal>0) {
					resMap.put("result", "ok");
					resMap.put("resultMsg", "삭제에 성공했습니다.");
				}
				else {
					resMap.put("resultMsg", "존재하지 않는 아이디 입니다.");
				}
			}
			catch(Exception e){
				e.printStackTrace();
				resMap.put("resultMsg",e.getMessage());
			}
			return resMap;
		}


	
}
