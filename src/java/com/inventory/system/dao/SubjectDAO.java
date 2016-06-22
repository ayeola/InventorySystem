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
public interface SubjectDAO {
    public Subjects addSubject(Subjects subject);
    public Subjects editSubject(Subjects subject);
    public List<Subjects> findSubjectByClass(AcademicClass stdClass);
    public List<Subjects> findSubjectByTeacher(Teacher teacher);
    public Subjects findSubjectBySubjectCode(String subjectCode);
    public Subjects findSubjectBySubjectNAme(String subjectName);
    public Subjects findSubjectByIndexValue(Integer indexValue);
    
}
