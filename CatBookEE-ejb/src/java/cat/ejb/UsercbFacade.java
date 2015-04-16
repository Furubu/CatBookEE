/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.ejb;

import cat.entity.Postcb;
import cat.entity.Usercb;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kuroneko
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
    
    public Integer getUserIdByEmail(String email){
        Query query = em.createQuery("SELECT u FROM Usercb u WHERE u.email = :email");
        query.setParameter("email", email);
        
        return query.getFirstResult();
    }
    

    public List<Postcb> getPosts(Integer idUser) {
        Query query = em.createQuery("SELECT p FROM Postcb p WHERE p.usercbId = :id");
        query.setParameter("id", idUser);

        List<Postcb> postList = query.getResultList();

        return postList;
    }
}
