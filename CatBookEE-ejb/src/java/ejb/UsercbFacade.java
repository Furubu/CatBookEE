/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Usercb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Furu
 */
@Stateless
public class UsercbFacade extends AbstractFacade<Usercb> {
    @PersistenceContext(unitName = "CatBookEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsercbFacade() {
        super(Usercb.class);
    }
    
}
