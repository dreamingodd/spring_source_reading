package ywd.bean.circularDependency;

public class CircleTestC {
    private CircleTestA a;

    public void c() {
        a.a();
    }

    public CircleTestA getA() {
        return a;
    }

    public void setA(CircleTestA a) {
        this.a = a;
    }
}
