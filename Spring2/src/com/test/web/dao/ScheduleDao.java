package com.test.web.dao;

import java.util.List;

import com.test.web.bean.MemberBean;
import com.test.web.bean.ScheduleBean;

public interface ScheduleDao {
	/*월행사 출력*/
    public List<ScheduleBean> selectScheduleList(ScheduleBean sBean);

}
