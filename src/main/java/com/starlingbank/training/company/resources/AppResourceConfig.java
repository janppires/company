package com.starlingbank.training.company.resources;

import com.starlingbank.training.CompanyModule;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

public class AppResourceConfig extends Application {

    Set<Class<?>> classes = new HashSet<>();
    
    public AppResourceConfig() {
        classes.add(EmployeeResource.class);
    }
    
    public Set<Class<?>> getClasses() {
        return classes;
    }
}