package com.zyc.p2p.key.sys.model;

import lombok.Data;


@Data
public class SysUser {
    private Integer userid;

    private String username;

    private String password;

    private String salt;

    private String createdate;

    private String rolename;

}