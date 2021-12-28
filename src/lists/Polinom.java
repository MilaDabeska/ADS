package lists;

class Coefficient implements Comparable<Coefficient> {
    private int coefficient, exponent;

    public Coefficient(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Coefficient add(Coefficient c) {
        return new Coefficient(coefficient + c.coefficient, exponent);
    }

    @Override
    public int compareTo(Coefficient o) {
        if (exponent > o.exponent) return 1;
        if (exponent < o.exponent) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%d*x^%d ", coefficient, exponent);
    }
}

public class Polinom {
    SLL<Coefficient> coefficientSLL = new SLL<>();

    public Polinom(SLL<Coefficient> coefficientSLL) {
        this.coefficientSLL = coefficientSLL;
    }

    public SLL<Coefficient> getCoefficientSLL() {
        return coefficientSLL;
    }

    public void setCoefficientSLL(SLL<Coefficient> coefficientSLL) {
        this.coefficientSLL = coefficientSLL;
    }

    public Polinom add(Polinom in) {
        SLL<Coefficient> list = in.getCoefficientSLL();

        SLLNode<Coefficient> node1 = coefficientSLL.getFirst();
        SLLNode<Coefficient> node2 = list.getFirst();
        SLL<Coefficient> result = new SLL<>();

        while (node1 != null && node2 != null) {
            if (node1.element.compareTo(node2.element) < 0) { // exponent1 < exponent2
                result.insertLast(node2.element); //go dodavame pogolemiot
                node2 = node2.succ;
            } else if (node1.element.compareTo(node2.element) > 0) { // exponent1 > exponent2
                result.insertLast(node1.element);
                node1 = node1.succ;
            } else {
                // exponent1 == exponent2
                Coefficient sum = node1.element.add(node2.element);
                result.insertLast(sum);
                node1 = node1.succ;
                node2 = node2.succ;
            }
        }
        while (node1 != null) { //iteracija
            result.insertLast(node1.element);
            node1 = node1.succ;
        }
        while (node2 != null) {
            result.insertLast(node2.element);
            node2 = node2.succ;
        }
        return new Polinom(result);
    }

    @Override
    public String toString() {
        return coefficientSLL.toString();
    }

    public static void main(String[] args) {
        SLL<Coefficient> coef1 = new SLL<>();
        coef1.insertLast(new Coefficient(2, 4));
        coef1.insertLast(new Coefficient(3, 0));
        System.out.println("Polinom 1: " + coef1.toString());
        Polinom polinom1 = new Polinom(coef1);

        SLL<Coefficient> coef2 = new SLL<>();
        coef2.insertLast(new Coefficient(1, 3));
        coef2.insertLast(new Coefficient(2, 2));
        coef2.insertLast(new Coefficient(8, 8));
        System.out.println("Polinom 2: " + coef2.toString());
        Polinom polinom2 = new Polinom(coef2);

        System.out.println("Sum: " + polinom1.add(polinom2));
    }
}
