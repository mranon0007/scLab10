/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labppl.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ehsan
 */
@Entity
@Table(name = "record")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Record.findAll", query = "SELECT r FROM Record r"),
    @NamedQuery(name = "Record.findById", query = "SELECT r FROM Record r WHERE r.id = :id"),
    @NamedQuery(name = "Record.findByType", query = "SELECT r FROM Record r WHERE r.type = :type"),
    @NamedQuery(name = "Record.findByRentDate", query = "SELECT r FROM Record r WHERE r.rentDate = :rentDate")})
public class Record implements Serializable {

    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "rent_date")
    @Temporal(TemporalType.DATE)
    private Date rentDate;
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Car carId;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User username;

    public Record() {
    }

    public Record(Integer id) {
        this.id = id;
    }

    public Record(Integer id, String type, Date rentDate) {
        this.id = id;
        this.type = type;
        this.rentDate = rentDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Record)) {
            return false;
        }
        Record other = (Record) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.labppl.entities.Record[ id=" + id + " ]";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
