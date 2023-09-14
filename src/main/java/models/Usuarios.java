package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {
    private ArrayList<Usuario> listaUsuarios;

    public Usuarios(){
        this.listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.add(new Usuario("Manuel", "1200.57", "Chavez", 1234));
        listaUsuarios.add(new Usuario("Carlos", "700.41", "Rodriguez", 1234));
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void agregarNuevoUsuario(){
        Scanner escaner = new Scanner(System.in);

        System.out.println("--Crear nueva Cuenta--");

        System.out.println("Ingrese su Nombre: ");
        String nombre = escaner.nextLine();

        System.out.println("Ingrese su Apellido: ");
        String apellido = escaner.nextLine();

        System.out.println("Ingrese su balance Inicial: ");
        String balance = escaner.nextLine();

        System.out.println("Ingrese su contraseña: ");
        int password = escaner.nextInt();

        Usuario u = new Usuario(nombre, balance, apellido, password);
        listaUsuarios.add(u);

        System.out.println("Su nuevo numero de cuenta es: " + u.getnUsuario());

    }

    public void mostrarCuentas(){
        for (Usuario lista: getListaUsuarios()){
            System.out.println(lista);
        }
    }
}
