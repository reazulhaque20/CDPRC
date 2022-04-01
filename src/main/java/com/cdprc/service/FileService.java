package com.cdprc.service;

import com.cdprc.model.Employees;
import com.cdprc.model.Files;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FileService {

    public static int findFileTypesByEmpName(List<Employees> employeesList, List<Files> filesList){
        Set<String> typeSet = new HashSet<>();
        Set<String> empNames =
                employeesList.stream()
                        .map(Employees::getName)
                        .collect(Collectors.toSet());
        Set<String> empId =
                employeesList.stream()
                        .map(Employees::getId)
                        .collect(Collectors.toSet());

        filesList.stream()
                .filter(e -> empNames.contains(e.getName()) || typeSet.add(e.getType()))
                .filter(e -> typeSet.add(e.getType()))
                .collect(Collectors.toList());

        return typeSet.size();
    }
}
