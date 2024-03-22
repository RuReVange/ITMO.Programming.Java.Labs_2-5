package itmo.dev.hibernate;

import itmo.dev.models.Breed;
import itmo.dev.models.Cat;
import itmo.dev.models.Color;
import itmo.dev.models.Owner;
import itmo.dev.repositories.impl.CatRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {

        Owner owner = Owner.builder().name("Ivan").birthDate(LocalDate.of(1999, 6, 30)).build();
        Cat cat = Cat.builder().name("Мурзик").birthDate(LocalDate.of(2023, 3, 8))
                .breed(Breed.BRITISH_SHORTHAIR).color(Color.GRAY).owner(owner).build();

        CatRepositoryImpl catRepository = new CatRepositoryImpl();
        Cat tmpCat = catRepository.findById(8);
        tmpCat.setName("Bobik");
        catRepository.update(tmpCat);
    }
}