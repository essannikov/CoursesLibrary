package main.model.dao;

import main.model.Student;

import java.util.List;

public class StudentDAO {
    public static List<Student> list(){
        /*
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root);
        List<Student> students = session.createQuery(query).getResultList();
        Collections.sort(students);

        session.close();

        return students;
        */

        return null;
    }

    public static Integer add(Student student){
        /*
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(student);
        transaction.commit();

        session.close();

        return student.getId(); //???
        */

        return 0;
    }

    public static Student get(Integer id){
        /*
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

        Student student = session.get(Student.class, id);

        session.close();

        return student;
        */

        return null;
    }
}
