package design_pattern.duck01;

import design_pattern.duck01.behavior.FlyBehavior;
import design_pattern.duck01.behavior.QuackBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {

    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly(); // 委托给行为类
    }

    public void performQuack() {
        quackBehavior.quack(); // 委托给行为类
    }

    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }

    public void swim() {
        System.out.println("All ducks float, even decoys");
    }
}
