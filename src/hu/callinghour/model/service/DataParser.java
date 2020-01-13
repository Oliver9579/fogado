package hu.callinghour.model.service;

import hu.callinghour.model.domain.CallingHour;

import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    public List<CallingHour> parse(List<String> lines) {
        return lines.stream()
                .map(this::createCallingHour)
                .collect(Collectors.toList());
    }

    private CallingHour createCallingHour(String line) {
        String[] items = line.split(" ");
        String teachersName = items[0] + " " + items[1];
        return new CallingHour(teachersName, items[2], items[3]);
    }
}
