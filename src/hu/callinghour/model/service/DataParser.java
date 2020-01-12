package hu.callinghour.model.service;

import hu.callinghour.model.domain.CallingHour;
import hu.callinghour.model.domain.TeachersName;

import java.util.ArrayList;
import java.util.List;

public class DataParser {


    public List<CallingHour> parse(List<String> lines) {
        List<CallingHour> callingHours = new ArrayList<>();
        return callingHours;
    }

    public CallingHour createCallingHour(String line, TeachersName teachersName) {
        String[] items = line.split(" ");
        return new CallingHour(teachersName, items[2], items[3]);
    }
}
