import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Digite a distancia em KM: ");
            BigDecimal distancia = new BigDecimal(sc.nextLine());
            distancia = distancia.setScale(3, RoundingMode.HALF_UP);

            System.out.println("Digite o tempo em horas: ");
            BigDecimal tempo = new BigDecimal(sc.nextLine());
            tempo = tempo.setScale(3, RoundingMode.HALF_UP);

            if (tempo.compareTo(BigDecimal.ZERO) == 0) {
                throw new IllegalArgumentException("O tempo nao pode ser zero");
            }

            BigDecimal velMedia = distancia.divide(tempo, 3, RoundingMode.HALF_UP);
            System.out.printf("Velocidade media: %.2f Km/h\n", velMedia.doubleValue());

        } catch (NumberFormatException e) {
            System.out.println("Insira valores numericos validos");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro " + e.getMessage());
        }

    }
}