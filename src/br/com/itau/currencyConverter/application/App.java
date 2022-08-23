package br.com.itau.currencyConverter.application;

import br.com.itau.currencyConverter.model.entities.CurrencyConverter;
import br.com.itau.currencyConverter.model.factory.CurrencyConverterFactory;

import java.util.Optional;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        boolean controller = true;

        do {
            Double realValue = getRealValue();
            String optionSelected = getOptionSelected();
            Optional<CurrencyConverter> currencyConverter = new CurrencyConverterFactory(realValue)
                    .create(optionSelected);

            while (currencyConverter.isEmpty()) {
                System.out.println("Opção inválida, escolha novamente !!!");
                optionSelected = getOptionSelected();
                currencyConverter = new CurrencyConverterFactory(realValue)
                        .create(optionSelected);
            }

            showResult(currencyConverter.get());
            System.out.println("Deseja realizar outra operação? (s/n)");
            char newOperation = scanner.next().charAt(0);

            if (newOperation == 'n') {
                controller = false;
            }
        } while (controller);
    }

    private static Double getRealValue() {
        System.out.print("Digite o valor em reais (R$): ");
        return scanner.nextDouble();
    }

    private static String getOptionSelected() {
        System.out.println("Digite a moeda de destino: \n 1. Euro \n 2. Dólar \n 3. Peso Argentino \n 4. Peso Chileno");
        System.out.println("-> ");
        return scanner.next();
    }

    private static void showResult(CurrencyConverter currencyConverter) {
        System.out.println("Valor em reais    -> R$ " + String.format("%.2f", currencyConverter.getValueInReal()));
        System.out.println("IOF    -> R$ " + String.format("%.2f", currencyConverter.getIof()));
        System.out.println("Taxa de operação    -> R$ " + String.format("%.2f", currencyConverter.getOperatingFee()));
        System.out.println("-------------------------");
        System.out.println("Total convertido -> R$ " + currencyConverter.getConvertValueFormat());
    }
}
