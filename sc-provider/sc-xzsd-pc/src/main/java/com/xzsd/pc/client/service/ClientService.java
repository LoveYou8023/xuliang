package com.xzsd.pc.client.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.client.dao.ClientDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientService {
    @Resource
    private ClientDao clientDao;
    /**
     * 查询客户列表
     */
    public AppResponse listClients(String userName, String userAcct, String role,int pageNum,int pageSize){
        String userId = SecurityUtils.getCurrentUserId();

        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> userInfoList = clientDao.listClientsByPage(userName,userAcct,role,userId);
        PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userInfoList);
        return AppResponse.success("查询信息成功",pageData);
    }

}