package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado3ModificarObjectoPersistente {

    public static void main(String[] args) {

       
       
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
       
       //crear conexion db
       EntityManager em = emf.createEntityManager();
       
       // pasar objecto persistence hibernate
       
       //esta en estado transitivo  (sin representacion en db por ahora)
       
       Contacto contacto = null;
       
       
         contacto = em.find(Contacto.class, 3);
         
         
       contacto.setEmail("55532.mail.com");
       
       contacto.setTelefono("23");
       
       // lo que vamos a hacer es guardar en db y pasar a persistente
       
       em.getTransaction().begin();
       
       //standar de jpa es persist
       em.persist(contacto);
       
       // ahora la persistencia se guarda a db
       em.getTransaction().commit();
       System.out.println("contacto="+contacto);
       
       
       
    }
}