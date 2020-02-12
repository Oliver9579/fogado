package hu.callinghour;

import hu.callinghour.controller.CallingService;
import hu.callinghour.model.service.*;

import java.util.List;
import java.util.Scanner;

public class App {

    private final CallingService callingService;
    private final Console console;


    App() {
        DataApi dataApi = new DataApi(new DataParser(), new FileReader());
        callingService = new CallingService(dataApi.getData("fogado.txt"), new FileWriter());
        console = new Console(new Scanner(System.in));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {

        System.out.println("2.feladat: Foglalások száma: " + callingService.countArrest());
//        System.out.println("3. feladat");
//        System.out.print("Adjnon meg egy nevet: ");
//        String name =console.read();
//        System.out.println(callingService.getAppointmentCount(name));
//        System.out.println("4. feladat");
//        System.out.print("Adjnon meg egy érvényes időpontot (Pl. 17:10): ");
//        String time =console.read();
//        System.out.println(callingService.writeResult(time));
        System.out.println("5.feladat");
        System.out.println(callingService.getFirstBookedAppointmentDetails());
        System.out.println(callingService.getFreeTimes("Barna Eszter"));

    }


}
