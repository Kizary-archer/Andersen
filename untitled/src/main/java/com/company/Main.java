package com.company;

import org.mockito.Mockito;

import java.util.List;

interface DataService {

    void saveData(List<String> dataToSave);

    String getDataById(String id);

    List<String> getData();

    List<String> getDataListByIds(List<String> idList);

}

public class Main {

    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        data.add("dataItem");
        Mockito.when(dataService.getAllData()).thenReturn(data);
    }
}
