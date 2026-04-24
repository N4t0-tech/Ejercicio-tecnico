import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicioSolucion1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los dígitos de la lista 1 separados por espacios (ej: 2 4 3):");
        List<Integer> lista1 = parseLine(scanner.nextLine().trim());

        System.out.println("Ingrese los dígitos de la lista 2 separados por espacios (ej: 5 6 4):");
        List<Integer> lista2 = parseLine(scanner.nextLine().trim());

        scanner.close();

        if (lista1.isEmpty() || lista2.isEmpty()) {
            System.out.println("Error: las listas no pueden estar vacías.");
            return;
        }

        if (lista1.get(0) == 0 || lista1.get(lista1.size() - 1) == 0 ||
            lista2.get(0) == 0 || lista2.get(lista2.size() - 1) == 0) {
            System.out.println("Error: las listas no pueden tener ceros al inicio ni al final.");
            return;
        }

        List<Integer> resultado = new ArrayList<>();
        int carry = 0;
        int maxLength = Math.max(lista1.size(), lista2.size());

        while (lista1.size() < maxLength) lista1.add(0);
        while (lista2.size() < maxLength) lista2.add(0);

        for (int i = lista1.size() - 1; i >= 0; i--) {
            int sum = lista1.get(i) + lista2.get(i) + carry;
            resultado.add(0, sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) resultado.add(0, carry);

        System.out.println("Resultado: " + resultado);
    }

    private static List<Integer> parseLine(String line) {
        List<Integer> list = new ArrayList<>();
        for (String part : line.split("\\s+")) {
            if (!part.isEmpty()) list.add(Integer.parseInt(part));
        }
        return list;
    }
}
