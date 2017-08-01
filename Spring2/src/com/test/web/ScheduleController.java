package com.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.bean.MemberBean;
import com.test.web.bean.ScheduleBean;
import com.test.web.dao.ScheduleDao;

@Controller
public class ScheduleController {
	
	@Autowired
	private ScheduleDao scheduleDao;
	
	
	@RequestMapping("/rest/ScheduleProc")
	@ResponseBody
	public Map<String, Object> ScheduleProc(ScheduleBean sBean){
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		try {
			List<ScheduleBean> list=scheduleDao.selectScheduleList(sBean);
			
			if(list==null) {
				resMap.put("result", "fail");
				resMap.put("resultMsg", "행사가 없습니다.");
			}else {
				resMap.put("result", "ok");
				resMap.put("scheduleBean", list);
			}

		}catch(Exception e){
			e.printStackTrace();
			resMap.put("result","fail");
		}
		return resMap;
	}
	

}
