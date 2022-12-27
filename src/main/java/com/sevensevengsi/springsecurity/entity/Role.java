package com.sevensevengsi.springsecurity.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_table", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "role_table_uk", columnNames = "rolename") })
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "rolename", length = 30, nullable = false)
    private String roleName;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
