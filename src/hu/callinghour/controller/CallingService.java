package hu.callinghour.controller;

import hu.callinghour.model.domain.CallingHour;
import hu.callinghour.model.service.FileWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CallingService {

    private final List<CallingHour> callingHour;
    private final FileWriter fileWriter;

    public CallingService(List<CallingHour> callingHour, FileWriter fileWriter) {
        this.callingHour = callingHour;
        this.fileWriter = fileWriter;

    }

    public int countArrest() {
        return callingHour.size();
    }

    public String getAppointmentCount(String name) {
        long count = countTeachersAppointment(name);
        return count == 0 ? " A megadott néven nincs időpontfoglalás" : String.format("%s néven %d időpontfoglalás van", name, count);
    }

    private long countTeachersAppointment(String name) {
        return callingHour.stream()
                .map(CallingHour::getTeachersName)
                .filter(teacherName -> teacherName.equals(name))
                .count();
    }

    public String writeResult(String time) {
        String teachersNameByTime = getTeachersNameByTime(time);
        String fileName = time.replace(":", "") + ".txt";
        fileWriter.write(fileName, teachersNameByTime);
        return teachersNameByTime;

    }

    private String getTeachersNameByTime(String time) {
        return callingHour.stream()
                .filter(i -> i.getArrest().equals(time))
                .map(CallingHour::getTeachersName)
                .sorted()
                .collect(Collectors.joining("\r\n"));
    }

    public String getFirstBookedAppointmentDetails() {
        CallingHour appointment = getFirstBookedAppointment();
        return String.format("Tanár neve: %s%nFoglalt időpont: %s%nFoglalás ideje: %s",
                appointment.getTeachersName(), appointment.getArrest(), appointment.getArrestDate());
    }

    private CallingHour getFirstBookedAppointment() {
        return callingHour.stream()
                .min(Comparator.comparing(CallingHour::getArrestDate))
                .get();
    }

    public String getFreeTimes(String name) {
        String[] timeArray = {"16:00", "16:10", "16:20", "16:30", "16:40", "16:50", "17:00", "17:10", "17:20", "17:30", "17:40", "17:50"};
        List<String> times = Arrays.stream(timeArray).collect(Collectors.toList());
        List<String> appointmentTimes = getAppointmentTimes(name);
        String last = appointmentTimes.get((appointmentTimes.size() - 1));
        times.removeAll(appointmentTimes);
        String leave = times.stream()
                .filter(i -> i.compareTo(last) == 1)
                .findFirst()
                .get();
        return String.format("%s%n%s legkorábban távozhat: %s", times.stream().collect(Collectors.joining("\n")), name, leave);
    }

    private List<String> getAppointmentTimes(String name) {
        return callingHour.stream()
                .filter(i -> i.getTeachersName().equals(name))
                .map(i -> i.getArrest())
                .sorted()
                .collect(Collectors.toList());
    }
}
