package mx.com.gm.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class EstadoDosRecuperaObjectoPersistente {

    public static void main(String[] args) {

       
       
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
       
       //crear conexion db
       EntityManager em = emf.createEntityManager();
       
       // pasar objecto persistence hibernate
       
       //esta en estado transitivo  (sin representacion en db por ahora)
       
       Contacto contacto =  null;
       
       
       
        // lo que vamos a hacer es guardar en db y pasar a persistente
       
        // se busca clase y pk de registro a recuperar retorna el tipo clase
        // pero populado
   contacto = em.find(Contacto.class, 3);
       
       // objeto persistente detached
       
       System.out.println("contacto="+contacto);
       
       
       
       
    }
}