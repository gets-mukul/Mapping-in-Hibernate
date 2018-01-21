package com.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Laptop laptop = new Laptop();
        laptop.setLid(111);
        laptop.setLname("dell");
        
        Student student = new Student();    
        student.setMarks(10);
        student.setName("Amit");
        student.setRollno(1);
        student.setLaptop(laptop);
        
        Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        
        ServiceRegistry registry =  new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = config.buildSessionFactory(registry) ; //deplicated method 
        
         Session session =sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(laptop);
        session.save(student);
        
        tx.commit();
    }
}
