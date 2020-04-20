package com.xzsd.pc.client.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.client.dao.ClientDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import static com.neusoft.core.page.PageUtils.getPageInfo;
@Service
public class ClientService {
    @Resource
    private ClientDao clientDao;
    /**
     * 查询客户列表
     */
    public AppResponse listClients(String userName, String userAcct, String role){
        String userId = SecurityUtils.getCurrentUserId();
        List<UserInfo> userList = clientDao.listClients(userName,userAcct,role,userId);
        // 包装Page对象
        PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userList);
        return AppResponse.success("查询信息成功",pageData);
    }

}