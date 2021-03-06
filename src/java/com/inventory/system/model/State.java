package com.inventory.system.model;
// Generated Jun 11, 2016 9:48:57 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * State generated by hbm2java
 */
@Entity
@Table(name="state"
    ,catalog="collegestudents"
)
public class State  implements java.io.Serializable {


     private Integer id;
     private String stateCode;
     private String stateName;
     private Set localGovernments = new HashSet(0);

    public State() {
    }

    public State(String stateCode, String stateName, Set localGovernments) {
       this.stateCode = stateCode;
       this.stateName = stateName;
       this.localGovernments = localGovernments;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="state_code", length=45)
    public String getStateCode() {
        return this.stateCode;
    }
    
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    
    @Column(name="state_name", length=45)
    public String getStateName() {
        return this.stateName;
    }
    
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="state")
    public Set getLocalGovernments() {
        return this.localGovernments;
    }
    
    public void setLocalGovernments(Set localGovernments) {
        this.localGovernments = localGovernments;
    }




}


