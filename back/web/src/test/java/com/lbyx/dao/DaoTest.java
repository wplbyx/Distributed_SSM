package com.lbyx.dao;

import com.lbyx.BaseSpringJunit4Test;
import com.lbyx.pojo.Admin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  Created by Administrator on 2017/12/12 0012.
 */
public class DaoTest extends BaseSpringJunit4Test {

    @Autowired
    private AdminDao dao;

    @Test
    public void daoTest(){
        Admin admin = dao.selectByPrimaryKey(1);
        System.out.println("[DaoTest method]: daoTest()->  admin" + admin);
    }

}
