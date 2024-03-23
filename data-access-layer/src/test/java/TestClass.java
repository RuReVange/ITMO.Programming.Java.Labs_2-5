import itmo.dev.models.Breed;
import itmo.dev.models.Cat;
import itmo.dev.models.Color;
import itmo.dev.models.Owner;
import itmo.dev.repositories.impl.CatRepositoryImpl;
import itmo.dev.repositories.interfaces.CatRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.List;

public class TestClass {

    @Mock
    CatRepository mockCatRepository;
    Owner owner;
    Cat cat;

    @BeforeEach
    public void setUp() {

        mockCatRepository = Mockito.mock(CatRepository.class);
        owner = Owner.builder().name("Ivan").birthDate(LocalDate.of(1999, 6, 30)).build();
        cat = Cat.builder().name("Мурзик").birthDate(LocalDate.of(2023, 3, 8))
                .breed(Breed.BRITISH_SHORTHAIR).color(Color.GRAY).owner(owner).build();
    }

    @Test
    public void getByIdTestMethod() {

        Mockito.when(mockCatRepository.findById(Mockito.any(Integer.class))).thenReturn(cat);

        Cat tmpCat = mockCatRepository.findById(8);

        Assertions.assertEquals(tmpCat, cat);
    }

    @Test
    public void updateTestMethod() {

        Mockito.when(mockCatRepository.findById(Mockito.any(Integer.class))).thenReturn(cat);

        Cat tmpCat = mockCatRepository.findById(8);
        tmpCat.setName("Bobik");
        Cat resultCat = mockCatRepository.update(tmpCat);

        Assertions.assertNotEquals(resultCat, cat);
    }

    @Test
    public void verifyTestMethod() {

        List<Cat> cats = List.of(new Cat(), new Cat());

        Mockito.when(mockCatRepository.findAll()).thenReturn(cats);

        List<Cat> tmpCats = mockCatRepository.findAll();

        Mockito.verify(mockCatRepository).findAll();
        Assertions.assertEquals(tmpCats, cats);
    }
}