/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.AcademicClass;
import com.inventory.system.model.Subjects;
import com.inventory.system.model.Teacher;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public class SubjectDAOImpl extends StaffDAOImpl implements SubjectDAO{

    @Override
    public Subjects addSubject(Subjects subject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Subjects editSubject(Subjects subject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Subjects> findSubjectByClass(AcademicClass stdClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Subjects> findSubjectByTeacher(Teacher teacher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Subjects findSubjectBySubjectCode(String subjectCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Subjects findSubjectBySubjectNAme(String subjectName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Subjects findSubjectByIndexValue(Integer indexValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
