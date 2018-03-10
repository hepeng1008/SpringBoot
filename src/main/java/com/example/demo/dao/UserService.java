package com.example.demo.dao;


import java.util.List;

public interface UserService {

    /**
     * 新增一个用户
     * @param name
     * @param id
     */
    void create(String name,Integer id);

    /**
     * 根据name删除一个用户
     * @param name
     *
     */

    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    List getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

    /**
     * 查询所有的用户数
     * @return 用户数
     */
    Integer getUserCount();
}
