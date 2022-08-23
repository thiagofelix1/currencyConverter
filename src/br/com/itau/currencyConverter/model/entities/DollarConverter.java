package br.com.itau.currencyConverter.model.entities;

public class DollarConverter extends CurrencyConverterWithVariableOperatingFee{

    private static final Double EXCHANGE_RATE = 0.19;
    private static final Double FLAT_VALUE_OPERATING_FEE = 5.0;
    private static final Double VARIABLE_VALUE_OPERATING_FEE = 0.03;

    public DollarConverter(Double valueInReal) {
        super(valueInReal);
    }

    @Override
    public Double getFlatValueOperatingFee() {
        return FLAT_VALUE_OPERATING_FEE;
    }

    @Override
    public Double getVariableValueOperatingFee() {
        return VARIABLE_VALUE_OPERATING_FEE;
    }

    @Override
    public Double getExchangeRate() {
        return EXCHANGE_RATE;
    }

    @Override
    public String doConvertValueFormat() {
        return "US$ ";
    }
}
