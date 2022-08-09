package mx.com.gm.test.cascade;

import javax.persistence.*;
import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;

public class PersistenciaCascadaTest {

   public static void main(String[] args) {

      // ejercicio de persistencia en cascada 
      
      
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");

      //crear conexion db
      EntityManager em = emf.createEntityManager();
      
      
      //esta en estado transitivo  (sin representacion en db por ahora)
       
      //posteriormente inserta domicilio no depende de ninguno
       Domicilio domicilio = new Domicilio();
       
       domicilio.setCalle("Nogales");
       domicilio.setNoCalle("1234");
       domicilio.setPais("mejico");
       
       //inserta primero este campo ya que no tiene ninguna dependencia con ninguna otra clase
       Contacto contacto = new Contacto();
       
       contacto.setEmail("clarita@mail.com");
       contacto.setTelefono("44332211");
       
       
       
       //finalmente inserta alumno que se necesita id de contacto y id de domicilio
       
       
       Alumno alumno = new Alumno();
       
       alumno.setNombre("maikel");
       alumno.setApellido("melamed");
       alumno.setDomicilio(domicilio);
       alumno.setContacto(contacto);
       
       em.getTransaction().begin();
       
       //se persisten los 3
       em.persist(alumno);
       System.out.println("alumno="+alumno);
   }
}
