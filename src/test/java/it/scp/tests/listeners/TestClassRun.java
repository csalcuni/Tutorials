package it.scp.tests.listeners;

import org.junit.runner.JUnitCore;

public class TestClassRun {

    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        runner.addListener(new MyListener());
        runner.run(TestClassA.class, TestClassB.class);

    }

}
