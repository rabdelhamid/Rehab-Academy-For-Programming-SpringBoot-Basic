/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "employee_cources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeCources.findAll", query = "SELECT e FROM EmployeeCources e")
    , @NamedQuery(name = "EmployeeCources.findById", query = "SELECT e FROM EmployeeCources e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeCources.findByCourseName", query = "SELECT e FROM EmployeeCources e WHERE e.courseName = :courseName")
    , @NamedQuery(name = "EmployeeCources.findByCourseDate", query = "SELECT e FROM EmployeeCources e WHERE e.courseDate = :courseDate")})
public class EmployeeCources implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_date")
    @Temporal(TemporalType.DATE)
    private Date courseDate;
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employees empId;

    public EmployeeCources() {
    }

    public EmployeeCources(Integer id) {
        this.id = id;
    }

    public EmployeeCources(Integer id, String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }

    public Employees getEmpId() {
        return empId;
    }

    public void setEmpId(Employees empId) {
        this.empId = empId;
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
        if (!(object instanceof EmployeeCources)) {
            return false;
        }
        EmployeeCources other = (EmployeeCources) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.EmployeeCources[ id=" + id + " ]";
    }
    
}
