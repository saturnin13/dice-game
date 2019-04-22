package test.player;


import main.dice.Dice;
import main.player.Player;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Rule;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class PlayerTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery() {{
        setThreadingPolicy(new Synchroniser());
    }};

    Dice mockNormalDice1 = context.mock(Dice.class, "mockNormalDice1");
    Dice mockNormalDice2 = context.mock(Dice.class, "mockNormalDice2");
    Dice mockNormalDice3 = context.mock(Dice.class, "mockNormalDice3");
    Dice mockNormalDice4 = context.mock(Dice.class, "mockNormalDice4");
    Dice mockNormalDice5 = context.mock(Dice.class, "mockNormalDice5");
    Dice mockNormalDice6 = context.mock(Dice.class, "mockNormalDice6");

    Player p1 = new Player();
    Set<Dice> normalDices = new TreeSet<>();

    @Test
    public void RollSingleDiceCallRollOnce() {
        context.checking(new Expectations(){{
            allowing(mockNormalDice1).compareTo(with(any(Dice.class)));
            will(returnValue(1));
            allowing(mockNormalDice2).compareTo(with(any(Dice.class)));
            will(returnValue(1));
            allowing(mockNormalDice3).compareTo(with(any(Dice.class)));
            will(returnValue(1));
            allowing(mockNormalDice4).compareTo(with(any(Dice.class)));
            will(returnValue(1));
            allowing(mockNormalDice5).compareTo(with(any(Dice.class)));
            will(returnValue(1));
            allowing(mockNormalDice6).compareTo(with(any(Dice.class)));
            will(returnValue(1));
            allowing(mockNormalDice1).getValue();
            will(returnValue(3));
            allowing(mockNormalDice2).getValue();
            will(returnValue(4));
            allowing(mockNormalDice3).getValue();
            will(returnValue(1));
            allowing(mockNormalDice4).getValue();
            will(returnValue(3));
            allowing(mockNormalDice5).getValue();
            will(returnValue(5));
            allowing(mockNormalDice6).getValue();
            will(returnValue(1));
            exactly(1).of(mockNormalDice1).roll();
            exactly(1).of(mockNormalDice2).roll();
            exactly(1).of(mockNormalDice3).roll();
            exactly(1).of(mockNormalDice4).roll();
            exactly(1).of(mockNormalDice5).roll();
            exactly(1).of(mockNormalDice6).roll();
        }});
        normalDices.add(mockNormalDice1);
        normalDices.add(mockNormalDice2);
        normalDices.add(mockNormalDice3);
        normalDices.add(mockNormalDice4);
        normalDices.add(mockNormalDice5);
        normalDices.add(mockNormalDice6);
        p1.setAllDices((TreeSet<Dice>) normalDices);
        p1.rerollAllDices();
    }
}
