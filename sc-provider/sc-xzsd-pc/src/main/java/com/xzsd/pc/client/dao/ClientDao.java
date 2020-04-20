package com.xzsd.pc.client.dao;
import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface ClientDao {
    /**
     * 查询客户列表
     */
    List<UserInfo> listClients(@Param("userName") String userName,
                               @Param("userAcct") String userAcct,
                               @Param("role") String role,
                               @Param("userId") String userId);

}