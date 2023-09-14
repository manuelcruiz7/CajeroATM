package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Cajero {

    private Usuarios usuarios;

    public Cajero(){
        this.usuarios = new Usuarios();
    }

    public void menu(){
        Scanner escaner = new Scanner(System.in);
        ArrayList<Usuario> lista = usuarios.getListaUsuarios();
        int bandera = 0;

        System.out.println("--Iniciar Sesion--\n" +
                "Numero de Cuenta: ");
        int nCuenta = escaner.nextInt();

        System.out.println("Contraseña: ");
        int password = escaner.nextInt();

        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getnUsuario() == nCuenta && lista.get(i).getPassword() == password) {
                menuOpciones(lista.get(i));
                bandera = 1;
            }
        }

        if(bandera == 0){
            System.out.println("El usuario o contraseña son incorrectos. ");
        }
    }

    public void menuOpciones(Usuario usuario){
        Scanner escaner = new Scanner(System.in);
        int bandera = 0;

        do{
            System.out.println("--Menu-- \n" +
                    "1. Retira Dinera\n" +
                    "2. Depositar Dinero\n" +
                    "3. Imprimir Datos Generales\n" +
                    "4. Salir\n");

            int opcion = escaner.nextInt();

            switch (opcion) {
                case 1 -> usuario.retirarDinero();
                case 2 -> usuario.depositarDinero();
                case 3 -> System.out.println(usuario);
                case 4 -> bandera = 1;
                default -> System.out.println("Digite alguna de las opciones del menu.");
            }
        }while(bandera == 0);
    }

    public void menuPrincipal(){
        Scanner escaner = new Scanner(System.in);
        int bandera = 0;

        do {
            System.out.println("1. Crear nueva Cuenta\n" +
                    "2. Iniciar Sesion\n" +
                    "3. Mostrar todas las cuentas creadas.\n" +
                    "4. Salir\n");

            int opcion = escaner.nextInt();

            switch (opcion) {
                case 1 -> usuarios.agregarNuevoUsuario();
                case 2 -> menu();
                case 3 -> usuarios.mostrarCuentas();
                case 4 -> bandera = 1;
                default -> System.out.println("Digite alguna de las opciones del menu");
            }
        }while(bandera == 0);
    }
}
