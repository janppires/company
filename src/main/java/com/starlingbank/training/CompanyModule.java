package com.starlingbank.training;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.starlingbank.training.company.persistence.DatabaseEmployeePersistenceService;
import com.starlingbank.training.company.persistence.EmployeePersistenceService;
import com.starlingbank.training.company.resources.EmployeeResource;

public class CompanyModule implements Module
{
   public void configure(final Binder binder)
   {
      binder.bind(EmployeeResource.class);
      binder.bind(EmployeePersistenceService.class).to(DatabaseEmployeePersistenceService.class);
   }
}