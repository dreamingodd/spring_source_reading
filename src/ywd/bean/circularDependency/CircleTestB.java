package ywd.bean.circularDependency;

public class CircleTestB {
    private CircleTestC c;

    public void b() {
        c.c();
    }

    public CircleTestC getC() {
        return c;
    }

    public void setC(CircleTestC c) {
        this.c = c;
    }
}
