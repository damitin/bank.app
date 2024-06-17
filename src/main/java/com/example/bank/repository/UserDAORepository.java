//NOT NEEDED anymore. Switched to using JPARepository
//package com.example.bank_app.dao;
//
//import com.example.bank_app.entity.User;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class UserDAOImpl implements UserDAO {
//    private EntityManager entityManager;
//
//    public UserDAOImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        Query query = entityManager.createQuery("from User");
//        List<User> allUsers = query.getResultList();
//        return allUsers;
//    }
//}
//
////TODO implement JPA repository and use default methods
