/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.AcademicClass;
import com.inventory.system.model.Accounts;
import com.inventory.system.model.Payments;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface PaymentsDAO{
    public Payments addPayment(Payments payment);
    public Payments updatePayment(Payments payment);
    public Payments findPaymentByAccount(Accounts account);
    public List<Payments> findPaymentByAcademicClass(AcademicClass stdClass);
    public List<Payments> findPaymentsByDateRange(Date fromDate,Date toDate);
    public List<Payments> fetchPayments();
}
