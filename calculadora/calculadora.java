public class calculadora {

    private float a, b;

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float somar() {
        return a + b;

    }

    public float subtrair() {
        return a - b;

    }

    public float divisao() {
        return a / b;

    }

    public float multiplicacao() {
        return a * b;

    }

    public float quadrado() {
        return a * a;
    }
}
