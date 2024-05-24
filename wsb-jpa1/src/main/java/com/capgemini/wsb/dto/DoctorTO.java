package com.capgemini.wsb.dto;

import java.io.Serializable;

import com.capgemini.wsb.persistence.enums.Specialization;

public class DoctorTO implements Serializable {
        
        private Long id;
        
        private String firstName;
        
        private String lastName;
        
        private Specialization specialization;
        
        private String telephoneNumber;

        private String email;

        private String doctorNumber;
        
        public Long getId() {
            return id;
        }
        
        public void setId(Long id) {
            this.id = id;
        }
        
        public String getFirstName() {
            return firstName;
        }
        
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        
        public String getLastName() {
            return lastName;
        }
        
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        
        public Specialization getSpecialization() {
            return specialization;
        }
        
        public void setSpecialization(Specialization specialization) {
            this.specialization = specialization;
        }
        
        public String getTelephoneNumber() {
            return telephoneNumber;
        }
    
        public void setTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    
        public String getDoctorNumber() {
            return doctorNumber;
        }
    
        public void setDoctorNumber(String doctorNumber) {
            this.doctorNumber = doctorNumber;
        }
    
}
