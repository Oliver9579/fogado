package hu.callinghour.model.domain;

public class CallingHour {

    private final String teachersName;
    private final String arrest;
    private final String arrestDate;

    public CallingHour(String teachersName, String arrest, String arrestDate) {
        this.teachersName = teachersName;
        this.arrest = arrest;
        this.arrestDate = arrestDate;
    }

    public String getTeachersName() {
        return teachersName;
    }

    public String getArrest() {
        return arrest;
    }

    public String getArrestDate() {
        return arrestDate;
    }
}

