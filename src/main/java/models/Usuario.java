package models;

import java.math.BigDecimal;
import java.util.Scanner;

public class Usuario {
    private String nombre;
    private BigDecimal balance;
    private String apellido;
    private int nUsuario;
    private int password;
    private static int UsuarioTotales;

    public Usuario(String nombre, String balanceInt, String apellido, int password){
        this.nombre = nombre;
        this.balance = new BigDecimal(balanceInt);
        this.apellido = apellido;
        this.password = password;
        nUsuario = UsuarioTotales++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getnUsuario() {
        return nUsuario;
    }

    public void setnUsuario(int nUsuario) {
        this.nUsuario = nUsuario;
    }

    public static int getUsuarioTotales() {
        return UsuarioTotales;
    }

    public static void setUsuarioTotales(int usuarioTotales) {
        UsuarioTotales = usuarioTotales;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String nombreCompleto(){return this.nombre + " " + this.apellido;}

    @Override
    public String toString() {
        System.out.flush();
        return "Nombre: " + nombreCompleto() + "\n" +
                "Numero de Cuenta: " + this.nUsuario + "\n" +
                "Balanace de Cuenta: " + this.balance + "\n" +
                "Password: " + this.password + "\n";
    }

    public void retirarDinero(){
        Scanner escaner = new Scanner(System.in);

        System.out.println("Balance General: " + getBalance());
        System.out.println("\nIngrese cuanto dinero desea retirar: \n");
        String retirar = escaner.nextLine();

        BigDecimal retirar2 = new BigDecimal(retirar);

        if (retirar2.compareTo(getBalance()) == 1){
            System.out.println("No cuenta con los fondos suficientes para realizar el retiro.");
        }else{
            this.balance = getBalance().subtract(retirar2);

            System.out.println("Retiro hecho correctamente");
            System.out.println("Nuevo Balance: " + getBalance());
        }
    }

    public void depositarDinero(){
        Scanner escaner = new Scanner(System.in);

        System.out.println("Balance General: " + getBalance());
        System.out.println("\nIngrese cuanto Dinero desea Depositar: ");
        String depositar = escaner.nextLine();

        BigDecimal depositar2 = new BigDecimal(depositar);

        this.balance = this.balance.add(depositar2);

        System.out.println("Nuevo Balance: " + this.balance);
    }
}
