package com.test.web.dao;

import java.util.List;

import com.test.web.bean.ShuttleBean;

public interface ShuttleDao {
	/*����� ���*/
    public List<ShuttleBean> selectShuttleLocation(ShuttleBean sBean);
    public int updateShuttleLocation(ShuttleBean sBean);

}
