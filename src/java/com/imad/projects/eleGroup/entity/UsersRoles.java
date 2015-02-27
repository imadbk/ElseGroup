/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imad.projects.eleGroup.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ibakli
 */
@Entity
@Table(name = "users_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersRoles.findAll", query = "SELECT u FROM UsersRoles u"),
    @NamedQuery(name = "UsersRoles.findByIdusersRoles", query = "SELECT u FROM UsersRoles u WHERE u.idusersRoles = :idusersRoles")})
public class UsersRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusers_roles")
    private Integer idusersRoles;
    @JoinColumn(name = "roleid", referencedColumnName = "idroles")
    @ManyToOne(optional = false)
    private Roles roleid;
    @JoinColumn(name = "userid", referencedColumnName = "idusers")
    @ManyToOne(optional = false)
    private Users userid;

    public UsersRoles() {
    }

    public UsersRoles(Integer idusersRoles) {
        this.idusersRoles = idusersRoles;
    }

    public Integer getIdusersRoles() {
        return idusersRoles;
    }

    public void setIdusersRoles(Integer idusersRoles) {
        this.idusersRoles = idusersRoles;
    }

    public Roles getRoleid() {
        return roleid;
    }

    public void setRoleid(Roles roleid) {
        this.roleid = roleid;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusersRoles != null ? idusersRoles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersRoles)) {
            return false;
        }
        UsersRoles other = (UsersRoles) object;
        if ((this.idusersRoles == null && other.idusersRoles != null) || (this.idusersRoles != null && !this.idusersRoles.equals(other.idusersRoles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.imad.projects.eleGroup.entity.UsersRoles[ idusersRoles=" + idusersRoles + " ]";
    }
    
}
