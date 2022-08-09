package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado4EliminarObjectoPersistente {

   public static void main(String[] args) {

      EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");

      //crear conexion db
      EntityManager em = emf.createEntityManager();

      // pasar objecto persistence hibernate
      //esta en estado transitivo  (sin representacion en db por ahora)
      Contacto contacto = null;

      contacto = em.find(Contacto.class, 3);


      // lo que vamos a hacer es guardar en db y pasar a persistente
      em.getTransaction().begin();

      //standar de jpa es persist
      //remove
      em.remove(contacto);

      // ahora la persistencia se guarda a db
      em.getTransaction().commit();
      
      // ya no es detached pasa a estado transitivo 
      //no se puede volver a sincronizar en la base de datos
      System.out.println("contacto=" + contacto);

   }
}
