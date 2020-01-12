package hu.callinghour;

import hu.callinghour.controller.CallingService;
import hu.callinghour.model.service.DataApi;
import hu.callinghour.model.service.DataParser;
import hu.callinghour.model.service.FileReader;

import java.util.List;

public class App {

    private final CallingService callingService;

    public App(CallingService callingService) {
        this.callingService = callingService;
    }

    App() {
        DataApi dataApi = new DataApi(new DataParser(), new FileReader());
        callingService = new CallingService(dataApi.getData("fogado.txt"));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {

        System.out.println("2.feladat: Foglalások száma: " + callingService.countArrest());
    }


}
