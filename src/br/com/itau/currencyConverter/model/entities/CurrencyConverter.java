package br.com.itau.currencyConverter.model.entities;

public abstract class CurrencyConverter {
    private final Double valueInReal;

    private static final Double IOF = 0.011;

    public CurrencyConverter(Double valueInReal) {
        this.valueInReal = valueInReal;
    }

    public Double getValueInReal() {
        return valueInReal;
    }

    public Double getIof(){
        return valueInReal * IOF;
    }

    public Double convert(){
        return (valueInReal - getOperatingFee() - getIof()) * getExchangeRate();
    }

    public String getConvertValueFormat() {
        return doConvertValueFormat() + String.format("%.2f", convert());
    }

    public abstract Double getOperatingFee();

    public abstract Double getExchangeRate();

    public abstract String doConvertValueFormat();
}
