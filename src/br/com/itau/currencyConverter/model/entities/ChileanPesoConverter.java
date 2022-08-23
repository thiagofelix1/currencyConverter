package br.com.itau.currencyConverter.model.entities;

public class ChileanPesoConverter extends CurrencyConverterWithVariableOperatingFee{

    private static final Double EXCHANGE_RATE = 174.17;
    private static final Double FLAT_VALUE_OPERATING_FEE = 10.0;
    private static final Double VARIABLE_VALUE_OPERATING_FEE = 0.025;

    public ChileanPesoConverter(Double valueInReal) {
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
        return "CLP ";
    }


}
