package com.analy.ley;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProbarHibernate {

    public static void main(String[] args) {
        try{
        Session sesion=HibernateUtilidades.getSessionFactory().openSession();
        //Paso 1: Empezar la sesion
        sesion.getTransaction().begin();
        
        //Paso 2: Hacer una operacion!!!
        sesion.save(new Pruebas(23,"Analy",12345));
        sesion.update(new Pruebas(23,"Analy",12345));
        
        Query q=sesion.createQuery("from Pruebas");
        
        ArrayList<Pruebas> pruebas=(ArrayList<Pruebas>)  q.list();
        for(Pruebas pru:pruebas){
            System.out.println(pru);
        }
        
        Criteria c = sesion.createCriteria(Pruebas.class);   
        ArrayList<Pruebas> pruebas2 = (ArrayList<Pruebas>)  c.list();
        for(Pruebas usu:pruebas2){
            System.out.println(usu);
        }       c.list();
      
        
        //Paso 3: Hacer el commit
        sesion.getTransaction().commit();
        
        //Paso 4: Cerrar la sesion, NO SE TE OLVIDE NUNCA ESTE!!!
        //No olvida el sesion.flush para transacciones masivas(PAGO DE NOMINA)
        sesion.close();
        
        System.out.println("Se ha guardado con EXITO su registro");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }   
}
