/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

/**
 *
 * @author javidiazdom
 */
public class Person {

    private String Nombre;
    private String Apellidos;
    private String Departamento;
    
    public Person(String nombre, String apellidos, String departamento) {
        Nombre=nombre;
        Apellidos=apellidos;
        Departamento=departamento;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getDepartamento() {
        return Departamento;
    }
    
    
    
}
