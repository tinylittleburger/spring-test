package com.example.demo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@SuppressWarnings("unchecked")
@Transactional
public class ImageRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Image image) {
        em.persist(image);
    }

    @Transactional(readOnly = true)
    public List<Image> findAll() {
        return em.createQuery("SELECT img FROM Image img").getResultList();
    }
    
    @Transactional(readOnly = true)
    public Image findOne(Integer id) {
        return em.find(Image.class, id);
    }
}
