import java.util.ArrayList;
import java.util.List;
public class ejercicioSolucion2 {
    public static void main(String[] args) {
        List<Integer> lista1 = List.of(2, 4, 3);
        List<Integer> lista2 = List.of(5, 6, 4);

        // Validamos que no haya ceros al inicio ni al final
        if (lista1.get(0) == 0 || lista1.get(lista1.size() - 1) == 0 ||
            lista2.get(0) == 0 || lista2.get(lista2.size() - 1) == 0) {
            System.out.println("Error: las listas no pueden tener ceros al inicio ni al final.");
            return;
        }
        // invertir
        List<Integer> revlist1 = new ArrayList<>(lista1);
        List<Integer> revlist2 = new ArrayList<>(lista2);
        java.util.Collections.reverse(revlist1);
        java.util.Collections.reverse(revlist2);

        // Suma elemento a elemento
        List<Integer> resultado = new ArrayList<>();
        int carry = 0;
        int maxLength = Math.max(revlist1.size(), revlist2.size());
        // Aseguramos que ambas listas tengan la misma longitud rellenando con ceros
        while (revlist1.size() < maxLength) {
            revlist1.add(0);
        }
        while (revlist2.size() < maxLength) {
            revlist2.add(0);
        }
        // Iteramos desde el primer dígito hacia el último
        for (int i = 0; i < revlist1.size(); i++) {
            resultado.add(revlist1.get(i) + revlist2.get(i) + carry);
            carry = resultado.get(i) / 10;
            resultado.set(i, resultado.get(i) % 10);
        }
        // Si hay un acarreo restante después de la última suma, lo agregamos al final de la lista de resultado
        if (carry > 0) {
                resultado.add(carry);
            }
        // Invertimos el resultado para obtener el número final en el orden correcto
        java.util.Collections.reverse(resultado);
        // Imprimimos el resultado final
        System.out.println("Resultado: " + resultado);
    }
}