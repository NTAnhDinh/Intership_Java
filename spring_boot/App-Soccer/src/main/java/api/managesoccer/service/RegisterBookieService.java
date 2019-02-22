package api.managesoccer.service;

import api.managesoccer.model.RegisterBookie;
import api.managesoccer.repository.RegisterBookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class RegisterBookieService {
    @Autowired
    RegisterBookieRepository registerBookieRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public RegisterBookie findOne(int id) {
        return registerBookieRepository.getOne(id);

    }
    @Transactional
    public void saveBookie(RegisterBookie r) {
        this.entityManager.persist(r);


    }

}
