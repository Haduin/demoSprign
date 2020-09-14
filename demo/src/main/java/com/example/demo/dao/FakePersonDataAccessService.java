package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<Person>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName(),person.getEmail(),person.getAdres()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonByID(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonByID(id);
        if(personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }



    @Override
    public int updatePersonById(UUID id, Person update) {
       return  selectPersonByID(id)
               .map(person -> {
                   int indexOfPersonToDelete = DB.indexOf(person);
                   if(indexOfPersonToDelete>=0){
                       DB.set(indexOfPersonToDelete,new Person(id,update.getName(),update.getEmail(),update.getAdres()));
                    return 1;
                   }else
                       return 0;
               }).orElse(0);
    }


}