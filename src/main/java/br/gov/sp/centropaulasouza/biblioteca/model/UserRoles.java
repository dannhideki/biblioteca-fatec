package br.gov.sp.centropaulasouza.biblioteca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hideki
 */
@Entity
@Table(name = "USER_ROLES")
public class UserRoles implements Serializable {
 
	private static final long serialVersionUID = 1211087729474911770L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + userRoleId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoles other = (UserRoles) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		return true;
	}

    
}