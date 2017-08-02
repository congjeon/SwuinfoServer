package com.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.bean.ShuttleBean;
import com.test.web.dao.ShuttleDao;

public class ShuttleController {
	@Autowired
	private ShuttleDao shuttleDao;
	
	@RequestMapping("/rest/updateShuttleLocation")
	@ResponseBody
	public Map<String, Object> updateMember(ShuttleBean sBean){
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result","fail");
		
		try {
		
			int resVal=shuttleDao.updateShuttleLocation(sBean);
			if(resVal>0) {
				resMap.put("result", "ok");
			}
			else {
				resMap.put("resultMsg", "셔틀번호를 확인하세요.");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			resMap.put("resultMsg",e.getMessage());
		}
		return resMap;
	}
	
	@RequestMapping("/rest/selectShuttleLocation")
	@ResponseBody
	public Map<String, Object> selectShuttleLocation(ShuttleBean sBean){
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		try {
		
			List<ShuttleBean> list=shuttleDao.selectShuttleLocation(sBean);
			
		resMap.put("result", "ok");
		resMap.put("shuttleLocationList", list);
		}catch(Exception e){
			e.printStackTrace();
			resMap.put("result","fail");
		}
		return resMap;
	}
}
