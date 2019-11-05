/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.jpaexample1.impl.dao.jpa.test;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.solent.com504.jpaexample1.impl.dao.jpa.DAOFactoryJPAImpl;
import org.solent.com504.jpaexample1.model.dao.PersonDAO;
import org.solent.com504.jpaexample1.model.dto.Person;
import org.solent.com504.jpaexample1.model.dto.Role;

/**
 *
 * @author cgallen
 */
public class PersonDAOTest {

    final static Logger LOG = LogManager.getLogger(PersonDAOTest.class);

    private PersonDAO personDao = null;

    private DAOFactoryJPAImpl daoFactory = new DAOFactoryJPAImpl();

    @Before
    public void before() {
        personDao = daoFactory.getPersonDAO();
        assertNotNull(personDao);
    }

    // initialises database for each test
    private void init() {
        // delete all in database
        String msg = "Init():";
        personDao.deleteAll();
        
        msg = msg + "\n   Cleared all people.";
        // add 5 patients
        for (int i = 1; i < 6; i++) {
            Person p = new Person();
            p.setAddress("address_" + i);
            p.setFirstName("firstName_" + i);
            p.setSecondName("secondName_" + i);
            p.setRole(Role.PATIENT);
            personDao.save(p);
            msg = msg + "\n   Created " + p.toString();
            
        }
        LOG.debug(msg);
    }

    @Test
    public void createPersonDAOTest() {
        LOG.debug("start of createPersonDAOTest");
        // this test simply runs the before method
        LOG.debug("end of createPersonDAOTest");
    }

    @Test
    public void findByIdTest() {
        LOG.debug("start of findByIdTest()");
        
        init();
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
    }

    @Test
    public void saveTest() {
        LOG.debug("start of saveTest()");
        
        init();
        
        Person person = new Person();
        person.setAddress("address_6");
        person.setFirstName("firstName_6");
        person.setSecondName("secondName_6");
        person.setRole(Role.PATIENT);
        personDao.save(person);
        LOG.debug("Created " + person.toString());
        
        LOG.debug("Retrieving " + person.toString() + " from database.");
        Person foundPerson = personDao.findById(person.getId());
        
        assertNotNull(foundPerson);
        LOG.debug("Comparing target: " + person.toString() + " with returned: " + foundPerson.toString());
        assertEquals(foundPerson.getFirstName(), person.getFirstName());
        assertEquals(foundPerson.getSecondName(), person.getSecondName());
        assertEquals(foundPerson.getAddress(), person.getAddress());
        assertEquals(foundPerson.getRole(), person.getRole());
        
        LOG.debug("end of saveTest()");
    }

    @Test
    public void findAllTest() {
        LOG.debug("start of findAllTest()");

        init();
        List<Person> personList = personDao.findAll();
        assertFalse(personList.isEmpty());
        
        // init should insert 5 people
        assertEquals(5, personList.size());

        // print out result
        String msg = "";
        for (Person person : personList) {
            msg = msg +"\n   " +  person.toString();
        }
        LOG.debug("findAllTest() retrieved:" + msg);
        LOG.debug("end of findAllTest()");
    }

    @Test
    public void deleteByIdTest() {
        LOG.debug("start of deleteByIdTest()");

        init();
        List<Person> personList = personDao.findAll();
        assertFalse(personList.isEmpty());
        
        assertEquals(5, personList.size());
        
        String msg = "";
        
        for (int i = 1; i < 6; i++) { 
            Person person = personList.get(i-1);
            assertNotNull(person);
            Long id = person.getId();

            personDao.deleteById(id);
            
            assertNull(personDao.findById(id));
            assertEquals(5 - i, personDao.findAll().size());
            
            msg = msg +"\n   Removed: " +  person.toString();
        }
        LOG.debug("deleteByIdTest():" + msg);
        LOG.debug("end of deleteByIdTest()");
    }

    @Test
    public void deleteTest() {
        LOG.debug("start of deleteTest()");
        
        init();
        
        List<Person> personList = personDao.findAll();
        assertNotNull(personList);
        
        assertEquals(5, personList.size());
        String msg = "";
        
        for (int i = 1; i < 6; i++) { 
            Person person = personList.get(i-1);
            assertNotNull(person);
            Long id = person.getId();
            
            personDao.delete(person);
            
            assertNull(personDao.findById(id));
            assertEquals(5 - i, personDao.findAll().size());
            
            msg = msg +"\n   Removed: " +  person.toString();
        }
        LOG.debug("deleteTest():" + msg);
        
        LOG.debug("end of deleteTest()");
    }

    @Test
    public void deleteAllTest() {
        LOG.debug("start of deleteAllTest())");
        
        init();
        assertNotNull(personDao.findAll());
        
        personDao.deleteAll();
        
        assertTrue(personDao.findAll().isEmpty());
        LOG.debug("deleteAllTest: Cleared all people.");
        
        LOG.debug("end of deleteAllTest()");
    }

    @Test
    public void findByRoleTest() {
        LOG.debug("start of findByRoleTest()");
     
        init();
        Person person = new Person();
        person.setAddress("address_6");
        person.setFirstName("firstName_6");
        person.setSecondName("secondName_6");
        person.setRole(Role.DENTIST);
        personDao.save(person);
        LOG.debug("Created " + person.toString());
        
        
        String msg = "";
        
        List<Person> patients = personDao.findByRole(Role.PATIENT);
        assertFalse(patients.isEmpty());
        msg = msg + "findByRole(Role.PATIENT) returned:";
        
        for (Person p : patients) {
            assertEquals(p.getRole(), Role.PATIENT);
            msg = msg + "\n  " + p.toString();
        }
        
        List<Person> dentists = personDao.findByRole(Role.DENTIST);
        assertFalse(dentists.isEmpty());
        msg = msg + "\nfindByRole(Role.DENTIST) returned:";
        
        for (Person p : dentists) {
            assertEquals(p.getRole(), Role.DENTIST);
            msg = msg + "\n  " + p.toString();
        }
        
        LOG.debug("findByRoleTest(): returned: " + msg);

        LOG.debug("end of findByIdTest()");
    }

    @Test
    public void findByNameTest() {
        LOG.debug("start of findByNameTest()");
        
        init();
        String msg = "";
        
        for (Person person : personDao.findAll()) {
            List<Person> results = personDao.findByName(person.getFirstName(), person.getSecondName());
            assertEquals(results.size(), 1);
            Person foundPerson = results.get(0);
            msg = msg +"\n   Comparing target: " + person.toString() + " with returned: " + foundPerson.toString();
            assertEquals(foundPerson.getFirstName(), person.getFirstName());
            assertEquals(foundPerson.getSecondName(), person.getSecondName());
            assertEquals(foundPerson.getAddress(), person.getAddress());
            assertEquals(foundPerson.getRole(), person.getRole());
        }
        LOG.debug("findByNameTest():" + msg);
        LOG.debug("end of findByNameTest())");

    }
}
