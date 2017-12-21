package com.lbyx.service;

import com.lbyx.BaseSpringJunit4Test;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.EasyUiDataGrid;

/**
 * Created by Administrator on 2017/12/19 0019.
 */
public class UserServiceTest extends BaseSpringJunit4Test {

    @Autowired
    private UserService userService;

    @Test
    public void getEasyUIDataGrid(){
        EasyUiDataGrid userListDataGrid = userService.getUserListDataGrid(1, 6);
        System.out.println("total:" + userListDataGrid.getTotal());
    }



}
