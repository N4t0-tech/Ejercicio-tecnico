import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicioSolucion2 {
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

        List<Integer> revlist1 = new ArrayList<>(lista1);
        List<Integer> revlist2 = new ArrayList<>(lista2);
        java.util.Collections.reverse(revlist1);
        java.util.Collections.reverse(revlist2);

        List<Integer> resultado = new ArrayList<>();
        int carry = 0;
        int maxLength = Math.max(revlist1.size(), revlist2.size());

        while (revlist1.size() < maxLength) revlist1.add(0);
        while (revlist2.size() < maxLength) revlist2.add(0);

        for (int i = 0; i < revlist1.size(); i++) {
            resultado.add(revlist1.get(i) + revlist2.get(i) + carry);
            carry = resultado.get(i) / 10;
            resultado.set(i, resultado.get(i) % 10);
        }

        if (carry > 0) resultado.add(carry);

        java.util.Collections.reverse(resultado);
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
