/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import game.Word;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author AsraniA
 */
public class WordDB {
    
    public static String getWordDB (int inputId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Query q = em.createNamedQuery("Word.findById", Word.class);
        q.setParameter("id", inputId);

        try {
            Word word = (Word) q.getSingleResult();
            return word.getWord();  
            
        } catch(NoResultException e) {
            return null;
            
        } finally {
            em.close();
        }
        
    }
    
}
