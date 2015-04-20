package br.gov.sp.centropaulasouza.biblioteca.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author hideki
 */
@Entity
@Table(name = "USER_ROLES")
public class UserRoles implements Serializable {
 
     @Id
    @GeneratedValue
    @Column(name = "USER_ROLE_ID")
    private int userRoleId;
   
    @Column(name = "role")
    private String role;

    public UserRoles() {
    }


    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}