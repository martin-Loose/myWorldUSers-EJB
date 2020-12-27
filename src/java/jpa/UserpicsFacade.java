/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Userpics;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marlo0212
 */
@Stateless
public class UserpicsFacade extends AbstractFacade<Userpics> implements UserpicsFacadeLocal {

    @PersistenceContext(unitName = "myWorldUsers-EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserpicsFacade() {
        super(Userpics.class);
    }
    
}
