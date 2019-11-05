/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.jpaexample1.impl.dao.jpa.test;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.solent.com504.jpaexample1.impl.dao.jpa.AppointmentDAOJpaImpl;
import org.solent.com504.jpaexample1.impl.dao.jpa.DAOFactoryJPAImpl;
import static org.solent.com504.jpaexample1.impl.dao.jpa.test.PersonDAOTest.LOG;
import org.solent.com504.jpaexample1.model.dao.AppointmentDAO;
import org.solent.com504.jpaexample1.model.dto.Appointment;
import org.solent.com504.jpaexample1.model.dto.Person;
import org.solent.com504.jpaexample1.model.dto.Role;


/**
 *
 * @author cgallen
 */
public class AppointmentDAOTest {

    final static Logger LOG = LogManager.getLogger(AppointmentDAOTest.class);

    private AppointmentDAO appointmentDao = null;

    private DAOFactoryJPAImpl daoFactory = new DAOFactoryJPAImpl();

    private List<Person> people = new ArrayList<>();
    
    // initialises database for each test
    private void init() {
        // delete all in database
        String msg = "Init():";
        appointmentDao.deleteAll();
        people.clear();
        
        for (int i = 1; i < 6; i++) {
            Person pat = new Person();
            pat.setFirstName("pat_" + i);
            pat.setRole(Role.PATIENT);
            people.add(pat);
            
            Person den = new Person();
            den.setFirstName("den_" + i);
            den.setRole(Role.DENTIST);
            people.add(den);
        }
        
        msg = msg + "\n   Cleared all appointments.";
        // add 5 patients
        for (int i = 1; i < 6; i++) {
            Appointment a = new Appointment();
            a.setDescripton("description_" + i);
            a.setDurationMinutes(i * 10);
            a.setHr(12 + i);
            a.setMth(i);
            a.setPersonA(people.get((2 * i) - 1));
            a.setPersonB(people.get(2 * i));
            a.setYr(2000 + i);
            appointmentDao.save(a);
            msg = msg + "\n   Created " + a.toString();
        }
        LOG.debug(msg);
    }
    
    @Before
    public void before() {
        appointmentDao = daoFactory.getAppointmentDAO();
        assertNotNull(appointmentDao);
    }

    @Test
    public void createAppointmentDAOTest() {
        LOG.debug("start of createAppointmentDAOTest(");
        // this test simply runs the before method
        LOG.debug("end of createAppointmentDAOTest(");
    }
    
    /**
     * Test of findById method, of class AppointmentDAOJpa.
     */
    @Test
    public void testFindById() {
        LOG.debug("start of findByIdTest()");
        
        init();
        
        /*
        String msg = "";
        
        for (Person person : personDao.findAll()) {
            Person foundPerson = personDao.findById(person.getId());
            assertNotNull(foundPerson);
            msg = msg +"\n   Comparing target: " + person.toString() + " with returned: " + foundPerson.toString();
            assertEquals(foundPerson.getFirstName(), person.getFirstName());
            assertEquals(foundPerson.getSecondName(), person.getSecondName());
            assertEquals(foundPerson.getAddress(), person.getAddress());
            assertEquals(foundPerson.getRole(), person.getRole());
        }
        LOG.debug("findByIdTest():" + msg);
        LOG.debug("end of findByIdTest()");
        
        
        System.out.println("findById");
        Long id = null;
        AppointmentDAOJpaImpl instance = null;
        Appointment expResult = null;
        Appointment result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of save method, of class AppointmentDAOJpa.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Appointment appointment = null;
        AppointmentDAOJpaImpl instance = null;
        Appointment expResult = null;
        Appointment result = instance.save(appointment);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class AppointmentDAOJpa.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        AppointmentDAOJpaImpl instance = null;
        List<Appointment> expResult = null;
        List<Appointment> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class AppointmentDAOJpa.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Appointment appointment = null;
        AppointmentDAOJpaImpl instance = null;
        Appointment expResult = null;
        Appointment result = instance.delete(appointment);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteById method, of class AppointmentDAOJpa.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        Long id = null;
        AppointmentDAOJpaImpl instance = null;
        instance.deleteById(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAll method, of class AppointmentDAOJpa.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        AppointmentDAOJpaImpl instance = null;
        instance.deleteAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByPersonA method, of class AppointmentDAOJpa.
     */
    @Test
    public void testFindByPersonA() {
        System.out.println("findByPersonA");
        Person personA = null;
        AppointmentDAOJpaImpl instance = null;
        List<Appointment> expResult = null;
        List<Appointment> result = instance.findByPersonA(personA);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByPersonB method, of class AppointmentDAOJpa.
     */
    @Test
    public void testFindByPersonB() {
        System.out.println("findByPersonB");
        Person personB = null;
        AppointmentDAOJpaImpl instance = null;
        List<Appointment> expResult = null;
        List<Appointment> result = instance.findByPersonB(personB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByDate method, of class AppointmentDAOJpa.
     */
    @Test
    public void testFindByDate() {
        System.out.println("findByDate");
        Integer year = null;
        Integer month = null;
        Integer hour = null;
        Integer minutes = null;
        AppointmentDAOJpaImpl instance = null;
        List<Appointment> expResult = null;
        List<Appointment> result = instance.findByDate(year, month, hour, minutes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
