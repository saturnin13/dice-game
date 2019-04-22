package test.dice;

import main.dice.Dice;
import main.dice.NormalDice;
import main.util.Constant;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

public class NormalDiceTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery() {{
        setThreadingPolicy(new Synchroniser());
    }};

    final int NUMBER_OF_ROLL = 100000;
    Dice d1 = new NormalDice();
    Dice d2 = new NormalDice();


    java.util.List<Integer> mockList = context.mock(java.util.List.class);

    @Test
    public void DiceRollRandom6FaceDiceNumber() {
            for (int i = 0; i < NUMBER_OF_ROLL; i++) {
            int currentRoll = d1.getValue();
            assertTrue(currentRoll > 0 && currentRoll < 7);
            d1.roll();
        }
    }

    @Test
    public void DiceValueRandom() {
        int[] list = new int[Constant.DICE_MAXIMUM_NUMBER_OF_FACE];

        for (int i = 0; i < NUMBER_OF_ROLL; i++) {
            int currentRoll = d1.getValue();
            assertTrue(currentRoll > 0 && currentRoll < 7);
            d1.roll();
            list[d1.getValue() - 1] += 1;
        }

        for (int elem : list) {
            assertTrue(elem > (NUMBER_OF_ROLL / Constant.DICE_MAXIMUM_NUMBER_OF_FACE) * 0.9 &&
                       elem < (NUMBER_OF_ROLL / Constant.DICE_MAXIMUM_NUMBER_OF_FACE) * 1.1);
        }
    }

    @Test
    public void DiceCorrectCompareTo() {
        d2.setValue(d1.getValue() - 1);
        assertTrue(d1.compareTo(d2) > 0);
        d2.setValue(d1.getValue());
        assertTrue(d1.compareTo(d2)== 0);
        d2.setValue(d1.getValue() + 1);
        assertTrue(d1.compareTo(d2) < 0);
    }
/*
    @Test
    public void canAddManyElementsInOrder() {

        context.checking(new Expectations(){{
            exactly(2).of(mockList).add(1);
            exactly(1).of(mockList).add(3);
            exactly(1).of(mockList).add(25);
        }});
        mappable.add(1);
        mappable.add(3);
        mappable.add(1);
        mappable.add(25);
    }
    @Test
    public void addReturnsCorrectFalseBoolean() {

        context.checking(new Expectations(){{
            allowing(mockList).add(with(any(Integer.class)));
            will(returnValue(false));
        }});
        assertFalse(mappable.add(8));
    }

    @Test
    public void addReturnsCorrectTrueBoolean() {

        context.checking(new Expectations(){{
            allowing(mockList).add(with(any(Integer.class)));
            will(returnValue(true));
        }});
        assertTrue(mappable.add(8));
    }

    @Test
    public void iteratorReturnsIteratorOfTheList() {

        final Iterator<Integer> iterator = context.mock(Iterator.class);
        context.checking(new Expectations(){{
            exactly(1).of(mockList).iterator(); will(returnValue(iterator));
        }});
        assertEquals(mappable.iterator(), iterator);
    }

    @Test
    public void mapCallsApplyToOnEveryElementInList() {

        final Function<Integer> mockFunction = context.mock(Function.class);
        context.checking(new Expectations(){{
            allowing(mockList).iterator(); will(returnIterator(1, 3, 2, 3, 3));
            exactly(1).of(mockFunction).applyTo(1);
            exactly(1).of(mockFunction).applyTo(2);
            exactly(3).of(mockFunction).applyTo(3);
            allowing(mockList).size();
        }});
        mappable.map(mockFunction);
    }

    @Test
    public void functionIsAppliedToEveryElementInList() {

        context.checking(new Expectations(){{
            allowing(mockList).iterator(); will(returnIterator(1, 2, 3, 4, 5));
            allowing(mockList).size();
        }});
        Iterable<Integer> mapped = mappable.map(function);
        assertThat(mapped, hasItems(1, 4, 9, 16, 25));
    }
    */
}