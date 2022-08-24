package br.com.itau.currencyConverter.application;

import br.com.itau.currencyConverter.model.entities.CurrencyConverter;
import br.com.itau.currencyConverter.model.factory.CurrencyConverterFactory;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        boolean controller = true;

        do {
            Double realValue = getRealValue();

            Optional<CurrencyConverter> currencyConverter = buildCurrencyConverter(realValue);

            while (currencyConverter.isEmpty()) {
                System.out.println("Opção inválida, escolha novamente !!!");
                currencyConverter = buildCurrencyConverter(realValue);
            }

            showResult(currencyConverter.get());
            System.out.println("Digite n para sair, para continuar digite outra tecla ");
            String newOperation = scanner.next();

            if (newOperation.equals("n")) {
                controller = false;
            }
        } while (controller);
    }

    private static Double getRealValue() {
        Double realValue = 0.0;
        do {
            try {
                System.out.print("Digite o valor em reais (R$): ");
                return scanner.nextDouble();
            }
            catch (InputMismatchException e) {
                System.out.println("Por favor digite um valor numérico e maior que zero");
            }
            scanner.nextLine();
        } while (realValue == 0);
        return realValue;
    }

    private static String getOptionSelected() {
        System.out.println("Digite a moeda de destino: \n 1. Euro \n 2. Dólar \n 3. Peso Argentino \n 4. Peso Chileno");
        System.out.print("-> ");
        return scanner.next();
    }

    private static Optional<CurrencyConverter> buildCurrencyConverter(Double realValue) {
        String optionSelected = getOptionSelected();
        return new CurrencyConverterFactory(realValue)
                .create(optionSelected);
    }

    private static void showResult(CurrencyConverter currencyConverter) {
        System.out.println("Valor em reais    -> R$ " + String.format("%.2f", currencyConverter.getValueInReal()));
        System.out.println("IOF    -> R$ " + String.format("%.2f", currencyConverter.getIof()));
        System.out.println("Taxa de operação    -> R$ " + String.format("%.2f", currencyConverter.getOperatingFee()));
        System.out.println("-------------------------");
        System.out.println("Total convertido -> R$ " + currencyConverter.getConvertValueFormat());
    }
}
