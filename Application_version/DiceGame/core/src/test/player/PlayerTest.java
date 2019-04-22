package test.player;

import org.junit.Test;

//TODO implement all unit test and other test when basics done (view basic, controller basic and model basic)
public class PlayerTest {

    @Test
    public void RollSingleDiceCallRollOnce() {

    }
}

/*
import main.dice.Character;
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

    Character mockNormalDice1 = context.mock(Character.class, "mockNormalDice1");
    Character mockNormalDice2 = context.mock(Character.class, "mockNormalDice2");
    Character mockNormalDice3 = context.mock(Character.class, "mockNormalDice3");
    Character mockNormalDice4 = context.mock(Character.class, "mockNormalDice4");
    Character mockNormalDice5 = context.mock(Character.class, "mockNormalDice5");
    Character mockNormalDice6 = context.mock(Character.class, "mockNormalDice6");

    Player p1 = new Player();
    Set<Character> normalDices = new TreeSet<>();

    @Test
    public void RollSingleDiceCallRollOnce() {
        context.checking(new Expectations(){{
            allowing(mockNormalDice1).compareTo(with(any(Character.class)));
            will(returnValue(1));
            allowing(mockNormalDice2).compareTo(with(any(Character.class)));
            will(returnValue(1));
            allowing(mockNormalDice3).compareTo(with(any(Character.class)));
            will(returnValue(1));
            allowing(mockNormalDice4).compareTo(with(any(Character.class)));
            will(returnValue(1));
            allowing(mockNormalDice5).compareTo(with(any(Character.class)));
            will(returnValue(1));
            allowing(mockNormalDice6).compareTo(with(any(Character.class)));
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
        p1.setAllDices((TreeSet<Character>) normalDices);
        p1.rerollAllDices();
    }
}
*/