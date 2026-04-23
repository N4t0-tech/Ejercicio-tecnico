import java.util.ArrayList;
import java.util.List;
public class ejercicioSolucion1 {
    public static void main(String[] args) {
        // Definimos dos números como listas de dígitos 
        List<Integer> lista1 = new ArrayList<>(List.of(2, 4, 3));
        List<Integer> lista2 = new ArrayList<>(List.of(5, 6, 4));
        // Validamos que no haya ceros al inicio ni al final (condicional: si el primer o último elemento de cualquiera de las listas es cero, se imprime un mensaje de error y se termina la ejecución del programa)
        if (lista1.get(0) == 0 || lista1.get(lista1.size() - 1) == 0 || lista2.get(0) == 0 || lista2.get(lista2.size() - 1) == 0) {
            System.out.println("Error: las listas no pueden tener ceros al inicio ni al final.");
            return;
        }
        //Definimos una lista para almacenar el resultado de la suma
        List<Integer> resultado = new ArrayList<>();
        int carry = 0; // Variable para llevar el acarreo
        int maxLength = Math.max(lista1.size(), lista2.size()); // Obtenemos la longitud máxima de las dos listas
        // Aseguramos que ambas listas tengan la misma longitud rellenando con ceros
        while (lista1.size() < maxLength) {
            lista1.add(0);
        }
        while (lista2.size() < maxLength) {
            lista2.add(0);
        }
        for (int i = lista1.size() - 1; i >= 0; i--) { // Iteramos desde el último dígito hacia el primero
            int sum = lista1.get(i) + lista2.get(i) + carry; // Sumamos los dígitos correspondientes y el acarreo
            resultado.add(0, sum % 10); // Agregamos el dígito resultante al inicio de la lista de resultado
            carry = sum / 10; // Calculamos el nuevo acarreo para la siguiente iteración
        }

        if (carry > 0) { // Si hay un acarreo restante después de la última suma, lo agregamos al inicio de la lista de resultado
            resultado.add(0, carry);
        }
        // Imprimimos el resultado final
        System.out.println("Resultado: " + resultado);
    }
}