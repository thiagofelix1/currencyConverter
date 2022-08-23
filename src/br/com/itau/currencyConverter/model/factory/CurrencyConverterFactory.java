package br.com.itau.currencyConverter.model.factory;

import br.com.itau.currencyConverter.model.entities.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CurrencyConverterFactory {
    private Map<String, CurrencyConverter> optionMap;

    public CurrencyConverterFactory(Double value) {
        optionMap = new HashMap<>();
        optionMap.put("1", new EuroConverter(value));
        optionMap.put("2", new DollarConverter(value));
        optionMap.put("3", new ArgentinianPesoConverter(value));
        optionMap.put("4", new ChileanPesoConverter(value));
    }

    public Optional<CurrencyConverter> create(String option) {
        return Optional.ofNullable(optionMap.get(option));
    }
}
