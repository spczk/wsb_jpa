package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;

public interface PatientService
{
    public PatientTO findById(final Long id);
    public PatientTO addPatient(final PatientTO patient) throws Exception;
    public PatientTO updatePatient(final PatientTO patient) throws Exception;
    public boolean deletePatient(final Long id);
}
