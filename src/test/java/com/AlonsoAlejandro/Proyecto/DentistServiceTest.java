package com.AlonsoAlejandro.Proyecto;

import com.AlonsoAlejandro.Proyecto.persistence.entities.Dentist;
import com.AlonsoAlejandro.Proyecto.service.Interfaces.DentistService;
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
public class DentistServiceTest {

    @Autowired
    private DentistService dentistService;

    public void chargeDataSet() {
       Dentist dentist=  dentistService.save(new Dentist("Mertens", "Dries", 977889));
       Dentist dentist1=  dentistService.save(new Dentist("Colombs", "Frank", 966373));
    }

    @Test
    public void saveAndSearchDentist() {
        this.chargeDataSet();
        Dentist dentist = dentistService.save(new Dentist("Mancini", "Leonardo", 665564));
        Assert.assertNotNull(dentistService.search(Math.toIntExact(dentist.getId())));
    }

    @Test
    public void deleteDentistTest() {
        dentistService.delete(1);
        Assert.assertTrue(dentistService.search(1).isEmpty());
    }

    @Test
    public void listDentistTest() {
        List<Dentist> dentists = dentistService.list();
        Assert.assertTrue(!dentists.isEmpty());
        Assert.assertTrue(dentists.size() == 2);
        System.out.println(dentists);
    }

}
