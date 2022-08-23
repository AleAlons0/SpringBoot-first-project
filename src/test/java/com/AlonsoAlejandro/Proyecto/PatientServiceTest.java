package com.AlonsoAlejandro.Proyecto;


import com.AlonsoAlejandro.Proyecto.persistence.entities.Address;
import com.AlonsoAlejandro.Proyecto.persistence.entities.Patient;
import com.AlonsoAlejandro.Proyecto.service.Interfaces.PatientService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;


    public void chargeDataSet() {
        Address address = new Address("Saint Etienne", 121312, "Mance", "Saint etienne");
        Patient patient = patientService.save(new Patient("Francois", "Bondie", 1232144, "22-05-2012", address));
        Address address1 = new Address("Carrera 30", 45335, "Center", "Bogota");
        Patient patient1 = patientService.save(new Patient("Federico", "Poveda", 40049494, "22-02-2021", address1));
    }

    @Test
    public void saveAndSearchPatientTest() {
        this.chargeDataSet();
        Address address = new Address("Calle", 23423, "Canterbury", "Mino");
        Patient patient = patientService.save(new Patient("Clark", "Pires", 123456, "30-01-2014", address));

        Assert.assertNotNull(patientService.search(Math.toIntExact(patient.getId())));
    }

    @Test
    public void deletePatientTest() {
        patientService.delete(2);
        Assert.assertTrue(patientService.search(2).isEmpty());
    }

    @Test
    public void listPatientsTest() {
        List<Patient> patients = patientService.list();
        Assert.assertTrue(!patients.isEmpty());
        Assert.assertTrue(patients.size() == 2);
        System.out.println(patients);
    }
}
