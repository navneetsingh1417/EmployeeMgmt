package com.dao;


import com.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public class EmpDAOImpl implements EmpDAO{

    private final SessionFactory sessionFactory;

    @Autowired
    public EmpDAOImpl(SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public boolean validate(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Employee where username=:username and password=:password");
        query.setParameter("username",username);
        query.setParameter("password",password);
        if((query.list().size() == 1)){
            return true;
        }
        return false;
    }



    @Override
    @Transactional
    public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Employee");
        return query.list();
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Employee where id=:id");
        query.setParameter("id",id);
        return (Employee) query.list().get(0);
    }

    @Override
    @Transactional
    public void addEmployee(Employee e) {
        Session session = sessionFactory.getCurrentSession();
        session.save(e);
    }
}
