/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Postcb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Furu
 */
@Stateless
public class PostcbFacade extends AbstractFacade<Postcb> {
    @PersistenceContext(unitName = "CatBookEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostcbFacade() {
        super(Postcb.class);
    }
    
}