package com.test.web.dao;

import java.util.List;

import com.test.web.bean.ShuttleBean;

public interface ShuttleDao {
	/*월행사 출력*/
    public List<ShuttleBean> selectShuttleLocation(ShuttleBean sBean);
    public int updateShuttleLocation(ShuttleBean sBean);

}
