package hu.callinghour.model.domain;

public class CallingHour {

    private final TeachersName teachersName;
    private final String arrest;
    private final String arrestDate;

    public CallingHour(TeachersName teachersName, String arrest, String arrestDate) {
        this.teachersName = teachersName;
        this.arrest = arrest;
        this.arrestDate = arrestDate;
    }

    public TeachersName getTeachersName() {
        return teachersName;
    }

    public String getArrest() {
        return arrest;
    }

    public String getArrestDate() {
        return arrestDate;
    }
}

