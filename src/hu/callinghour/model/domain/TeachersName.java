package hu.callinghour.model.domain;

public class TeachersName {

    private final String name;


    public TeachersName(String name) {

        this.name = name;

    }

    public TeachersName createName(String line) {
        String[] items = line.split(" ");
        String id = items[0] + " " + items[1];
        return new TeachersName(id);


    }
}

