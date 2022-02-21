package design_pattern.duck01;

import design_pattern.duck01.behavior.FlyNoWay;
import design_pattern.duck01.behavior.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("a model duck");
    }
}
