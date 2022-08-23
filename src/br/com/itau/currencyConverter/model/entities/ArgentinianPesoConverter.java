package br.com.itau.currencyConverter.model.entities;

public class ArgentinianPesoConverter extends CurrencyConverterWithVariableOperatingFee{

    private static final Double EXCHANGE_RATE = 26.24;
    private static final Double FLAT_VALUE_OPERATING_FEE = 2.50;
    private static final Double VARIABLE_VALUE_OPERATING_FEE = 0.015;

    public ArgentinianPesoConverter(Double valueInReal) {
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
        return "ARS ";
    }
}
