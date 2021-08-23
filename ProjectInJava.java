/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectinjava;

import java.util.Scanner;

/**
 *
 * @author Henri
 */
public class ProjectInJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Controller controller = new Controller();
        int id, idDep, mo, zgjedhja, iddep, nr, psw;
        double p;
        String e, mb, ll, lloji, ad;

        
        /*Passwordi supozohet te jete nje kombinim numrash i njohur vetem nga 
        personat e autorizuar per te hyre ne sistem.Ne kete rast,kemi marre
        shembullin kur passwordi eshte 12345678*/
        System.out.println("Shkruani passwordin per te hyre ne sistem:");
        psw = sc.nextInt();
        if (psw == 12345678) {
            do {
                System.out.println("Zgjidhni nje nga opsionet:");
                System.out.println("1 --> Shiko departamentet");
                System.out.println("2 --> Shto nje departament");
                System.out.println("3 --> Ndrysho te dhenat e nje departamenti");
                System.out.println("4 --> Fshi nje departament");
                System.out.println("5 --> Shiko punonjesit");
                System.out.println("6 --> Shto nje punonjes");
                System.out.println("7 --> Ndrysho te dhenat e nje punonjesi");
                System.out.println("8 --> Fshi nje punonjes");
                System.out.println("0 --> Dil nga sistemi");
                System.out.println("---------------------------------------------------");
                System.out.print("Zgjedhja juaj: ");
                zgjedhja = sc.nextInt();
                if (zgjedhja == 1) {
                    System.out.println();
                    controller.shihDepartamentet();
                    System.out.println("---------------------------------------------------");
                } else if (zgjedhja == 2) {
                    System.out.println();
                    System.out.print("Vendosni id e departamentit: ");
                    iddep = sc.nextInt();
                    System.out.print("Vendosni llojin e departamentit: ");
                    lloji = sc.next();
                    System.out.print("Vendosni emrin e administratorit: ");
                    ad = sc.next();
                    controller.shtoDepartament(iddep, lloji, ad);
                    System.out.println();
                    System.out.println("Departamenti i ri me id " + iddep + " u regjistrua me sukses.");
                    System.out.println("---------------------------------------------------");
                } else if (zgjedhja == 3) {
                    System.out.println();
                    System.out.print("Shkruani id e departamentit qe do te ndryshoni: ");
                    iddep = sc.nextInt();
                    System.out.print("Shkruani emrin e administratorit te ri: ");
                    ad = sc.next();
                    controller.updateDepartament(iddep, ad);
                    System.out.println();
                    System.out.println("Ndryshimi ne departamentin me id " + iddep + " u krye me sukses.");
                    System.out.println("---------------------------------------------------");
                } else if (zgjedhja == 4) {
                    System.out.println();
                    System.out.print("Vendosni id e departamentit qe do te fshini: ");
                    iddep = sc.nextInt();
                    controller.deleteDepartament(iddep);
                    System.out.println();
                    System.out.println("Departamenti me id " + iddep + " u fshi me sukses.");
                    System.out.println("---------------------------------------------------");
                } else if (zgjedhja == 5) {
                    System.out.println();
                    controller.shihPunonjesit();
                    System.out.println("---------------------------------------------------");
                } else if (zgjedhja == 6) {
                    System.out.println();
                    System.out.print("Vendosni id e punonjesit: ");
                    id = sc.nextInt();
                    System.out.print("Vendosni id e departamentit ku do te beje pjese punonjesi: ");
                    idDep = sc.nextInt();
                    System.out.print("Vendosni emrin: ");
                    e = sc.next();
                    System.out.print("Vendosni mbiemrin: ");
                    mb = sc.next();
                    System.out.print("Vendosni moshen: ");
                    mo = sc.nextInt();
                    System.out.print("Vendosni pagen: ");
                    p = sc.nextDouble();
                    System.out.print("Vendosni llojin e punonjesit ( FT per FULLTIME ose PT per partime): ");
                    ll = sc.next();
                    controller.shtoPunonjes(id, idDep, e, mb, mo, p, ll);
                    System.out.println();
                    System.out.println("Punonjesi me id " + id + " u regjistrua me sukses.");
                    System.out.println("---------------------------------------------------");
                } else if (zgjedhja == 7) {
                    System.out.println();
                    System.out.print("Vendosni id e punonjesit qe do te ndryshoni: ");
                    id = sc.nextInt();
                    System.out.print("Vendosni id e departamentit te ri(nese do te transferohet"
                            + ") ku do te beje pjese punonjesi: ");
                    idDep = sc.nextInt();
                    System.out.print("Vendosni emrin e ri: ");
                    e = sc.next();
                    System.out.print("Vendosni mbiemrin e ri: ");
                    mb = sc.next();
                    System.out.print("Vendosni moshen e re: ");
                    mo = sc.nextInt();
                    System.out.print("Vendosni pagen e re: ");
                    p = sc.nextDouble();
                    System.out.print("Vendosni llojin e ri: ");
                    ll = sc.next();
                    controller.updatePunonjes(id, idDep, e, mb, mo, p, ll);
                    System.out.println();
                    System.out.println("Ndryshimi per punonjesin me id " + id + " u krye me sukses.");
                    System.out.println("---------------------------------------------------");
                } else if (zgjedhja == 8) {
                    System.out.println();
                    System.out.print("Vendosni id e punonjesit qe do te fshini: ");
                    id = sc.nextInt();
                    System.out.print("Vendosni id e departamentit ku punonjesi ben pjese: ");
                    idDep = sc.nextInt();
                    controller.deletePunonjes(id, idDep);
                    System.out.println();
                    System.out.println("Punonjesi me id " + id + " u fshi me sukses.");
                    System.out.println("---------------------------------------------------");
                }
            } while (zgjedhja != 0);
        } else {
            System.out.println("Passwordi eshte i pasakte.");
        }
    }
}
