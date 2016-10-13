package ywd.bean.circularDependency;

public class CircleTestA {
    private CircleTestB b;

    public void a() {
        b.b();
    }

    public CircleTestB getB() {
        return b;
    }

    public void setB(CircleTestB b) {
        this.b = b;
    }
}
