package com.exam.system.exam.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    private Long rolId;
    private String rolName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<UserRol> userRols = new HashSet<>();

    /**
     * @return Long return the rolId
     */
    public Long getRolId() {
        return rolId;
    }

    /**
     * @param rolId the rolId to set
     */
    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    /**
     * @return String return the rolName
     */
    public String getRolName() {
        return rolName;
    }

    /**
     * @param rolName the rolName to set
     */
    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    /**
     * @return Set<UserRol> return the userRols
     */
    public Set<UserRol> getUserRols() {
        return userRols;
    }

    /**
     * @param userRols the userRols to set
     */
    public void setUserRols(Set<UserRol> userRols) {
        this.userRols = userRols;
    }

}
