package com.analy.ley;

import org.hibernate.Session;

public class ProbarHibernate {

    public static void main(String[] args) {
        try{
        Session sesion=HibernateUtilidades.getSessionFactory().openSession();
        //Paso 1: Empezar la sesion
        sesion.getTransaction().begin();
        //Paso 2: Hacer una operacion!!!
        sesion.save(new Pruebas(23,"Analy",12345));
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
