package br.com.itau.currencyConverter.model.entities;

public abstract class CurrencyConverterWithVariableOperatingFee extends CurrencyConverter{

    public CurrencyConverterWithVariableOperatingFee(Double valueInReal) {
        super(valueInReal);
    }

    @Override
    public  Double getOperatingFee() {
        return getFlatValueOperatingFee() + getVariableValueOperatingFee() * getValueInReal();
    }

    public abstract Double getFlatValueOperatingFee();

    public abstract Double getVariableValueOperatingFee();
}
