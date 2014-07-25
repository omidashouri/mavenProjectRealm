/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ir.omidashouri.services;

import ir.omidashouri.entity.Register;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author omid
 */
@Stateless
public class RegisterService {
    
    @PersistenceContext(unitName = "ir.omidashouri_mavenproject1_war_1.0-SNAPSHOTPU")
    EntityManager entityManager;
    
    
   private Register register;
    
    @PostConstruct
    public void init(){
        register = new Register();
    }
    
    
    public void selectTest(){
        try {
        register =   entityManager.find(Register.class, 1l);
        } catch (Exception e) {
        }
    }
}
