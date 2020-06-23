package ru.job4j.ood.tictactoe;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.*;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class PlaceByThreeTest {

    @Test
    public void addStepTrueTest() {
        PlaceByThree placeByThree = new PlaceByThree();
        Gamer gamer = Mockito.mock(Gamer.class);
        boolean out = placeByThree.addStep(BoxByThree.B1, gamer);
        assertThat(out, is(true));
    }

    @Test
    public void addStepFalseTest() {
        PlaceByThree placeByThree = new PlaceByThree();
        Gamer gamer = Mockito.mock(Gamer.class);
        placeByThree.addStep(BoxByThree.B1, gamer);
        boolean out = placeByThree.addStep(BoxByThree.B1, gamer);
        assertThat(out, is(false));
    }

    @Test
    public void getFreePlacesTest() {
        PlaceByThree placeByThree = new PlaceByThree();
        Gamer gamer = Mockito.mock(Gamer.class);
        placeByThree.addStep(BoxByThree.B1, gamer);
        placeByThree.addStep(BoxByThree.B2, gamer);
        placeByThree.addStep(BoxByThree.B3, gamer);
        placeByThree.addStep(BoxByThree.B4, gamer);
        placeByThree.addStep(BoxByThree.B5, gamer);
        List<BoxByThree> out = placeByThree.getFreePlaces();
        assertThat(out.toArray(), arrayContainingInAnyOrder(BoxByThree.B6,
                BoxByThree.B7,
                BoxByThree.B8,
                BoxByThree.B9));
    }
}