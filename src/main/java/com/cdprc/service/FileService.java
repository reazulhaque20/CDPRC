package com.cdprc.service;

import com.cdprc.model.Employees;
import com.cdprc.model.Files;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FileService {

    public int findFileTypesByEmpName(List<Employees> employeesList, List<Files> filesList) {
        Set<String> typeSet = new HashSet<>();
        Set<String> empSet = new HashSet<>();

        employeesList.stream()
                .filter(e -> empSet.add(e.getId()))
                .filter(e -> empSet.add(e.getName()))
                .collect(Collectors.toList());

        filesList.stream()
                .filter(e -> empSet.contains(e.getName()))
                .filter(e -> typeSet.add(e.getType()))
                .collect(Collectors.toList());

        return typeSet.size();
    }
}
