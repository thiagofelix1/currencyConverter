package br.com.itau.currencyConverter.model.entities;

public class EuroConverter extends CurrencyConverter{
    private static final Double EXCHANGE_RATE = 0.2;
    private static final Double FLAT_VALUE_OPERATING_FEE = 6.0;

    public EuroConverter(Double valueInReal) {
        super(valueInReal);
    }

    @Override
    public Double getOperatingFee() {
        return FLAT_VALUE_OPERATING_FEE;
    }

    @Override
    public Double getExchangeRate() {
        return EXCHANGE_RATE;
    }

    @Override
    public String doConvertValueFormat() {
        return "EUR ";
    }
}
