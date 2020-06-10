package ru.job4j.ood.tictactoe;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.*;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class PlaceTest {

    @Test
    public void addStepTrueTest() {
        Place place = new Place();
        Gamer gamer = Mockito.mock(Gamer.class);
        boolean out = place.addStep(BoxByThree.B1, gamer);
        assertThat(out, is(true));
    }

    @Test
    public void addStepFalseTest() {
        Place place = new Place();
        Gamer gamer = Mockito.mock(Gamer.class);
        place.addStep(BoxByThree.B1, gamer);
        boolean out = place.addStep(BoxByThree.B1, gamer);
        assertThat(out, is(false));
    }


    @Test
    public void getFreePlacesTest() {
        Place place = new Place();
        Gamer gamer = Mockito.mock(Gamer.class);
        place.addStep(BoxByThree.B1, gamer);
        place.addStep(BoxByThree.B2, gamer);
        place.addStep(BoxByThree.B3, gamer);
        place.addStep(BoxByThree.B4, gamer);
        place.addStep(BoxByThree.B5, gamer);
        List<BoxByThree> out = place.getFreePlaces();
        assertThat(out.toArray(), arrayContainingInAnyOrder(BoxByThree.B6,
                BoxByThree.B7,
                BoxByThree.B8,
                BoxByThree.B9));
    }

    @Test
    public void testToStringTest() {
        Place place = new Place();
        String line = place.toString();
        int i = 0;
    }
}