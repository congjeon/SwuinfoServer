package com.test.web.dao;

import com.test.web.bean.ScheduleBean;

public interface ScheduleDao {
	/*schedule 데이터 불러오기*/
    public ScheduleBean scheduleProc(ScheduleBean bean);

}
