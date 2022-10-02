public class RationalCalculator extends AbstractCalculator{
    public RationalCalculator(CalculationOperation add, CalculationOperation subtract, CalculationOperation multiply, CalculationOperation divide) {
        super(add, subtract, multiply, divide);
    }

    @Override
    public Number add(Number a, Number b) {
        Number result = add.calc(a, b);
        double ggt = ggt(result);
        result.setA(result.getA()/ggt);
        result.setB(result.getB()/ggt);
        return result;
    }

    @Override
    public Number subtract(Number a, Number b) {
        Number result = subtract.calc(a, b);
        double ggt = ggt(result);
        result.setA(result.getA()/ggt);
        result.setB(result.getB()/ggt);
        return result;
    }

    @Override
    public Number multiply(Number a, Number b) {
        Number result = multiply.calc(a, b);
        double ggt = ggt(result);
        result.setA(result.getA()/ggt);
        result.setB(result.getB()/ggt);
        return result;
    }

    @Override
    public Number divide(Number a, Number b) {
        Number result = divide.calc(a, b);
        double ggt = ggt(result);
        result.setA(result.getA()/ggt);
        result.setB(result.getB()/ggt);
        return result;
    }

    public double ggt(Number result)
    {
        double ggt;
        double a = result.getA();
        double b = result.getB();

        if (a == 0)
        {
            ggt = b;
        }

        while (b != 0)
        {
            if (a > b)
            {
                a = a - b;
            }
            else
            {
                b = b - a;
            }
        }

        ggt = a;
        return ggt;
    }
}
