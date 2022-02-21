package design_pattern.duck01;

import design_pattern.duck01.behavior.FlyWithWings;
import design_pattern.duck01.behavior.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I am a rel Mallard duck");
    }
}
