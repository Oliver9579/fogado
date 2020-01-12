package hu.callinghour.model.service;

import hu.callinghour.model.domain.CallingHour;

import java.util.List;

public class DataApi {

    private final DataParser dataParser;
    private final FileReader fileReader;

    public DataApi(DataParser dataParser, FileReader fileReader) {
        this.dataParser = dataParser;
        this.fileReader = fileReader;
    }

    public List<CallingHour> getData(String input) {
        return dataParser.parse(fileReader.read(input));
    }
}
