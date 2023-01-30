package leetcode.practice;

public class InheriTest {

    public static void main(String[] args) {
        new Child();
        new Child2();
    }

    public static class Child extends Parent {

    }

    public static class Child2 extends Parent {
        public Child2() {
            super();
        }
    }

    public static class Parent {

    }
}
