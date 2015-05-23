package com.wordpress.bmadi.belajar.hibernate.select.main;

import com.wordpress.bmadi.belajar.hibernate.select.model.Employee;
import com.wordpress.bmadi.belajar.hibernate.select.model.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainSelect {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employee andi = new Employee();
        andi.setFirstName("Madi");
        andi.setLastName("Andi");
        andi.setEmail("madiandi@gmail.com");
        session.save(andi);

        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        Query querySelect = session.createQuery("from Employee");
        List<Employee> andis = querySelect.list();
        for (Employee emp : andis) {
            System.out.println("id : " + emp.getId());
            System.out.println("first name : " + emp.getFirstName());
            System.out.println("last name : " + emp.getLastName());
        }
        session.close();
    }
}
