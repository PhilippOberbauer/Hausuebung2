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
        double a = result.getA();
        if (a < 0)
        {
            a = -a;
        }
        double b = result.getB();
        if (b < 0)
        {
            b = -b;
        }

        if (a == 0)
        {
            return b;
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

        return a;
    }
}
