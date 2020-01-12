package hu.callinghour.controller;

import hu.callinghour.model.domain.CallingHour;

import java.util.List;

public class CallingService {

    private final List<CallingHour> callingHour;

    public CallingService(List<CallingHour> callingHour) {
        this.callingHour = callingHour;
    }

    public int countArrest() {
        return callingHour.size();
    }
}
