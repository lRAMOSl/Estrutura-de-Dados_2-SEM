import java.util.Scanner;

public class principal_calculadora

{
    static calculadora cd = new calculadora();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(
                "Qual operação deseja realizar? \n[1]Somar \n[2]Subtrair \n[3]Divisão \n[4]Multiplicação \n[5]Quadrado");
        int resp = sc.nextInt();

        switch (resp) {
            case 1:
                System.out.println("Digite o primeiro valor: ");
                cd.setA(sc.nextFloat());
                System.out.println("Digite o segundo valor: ");
                cd.setB(sc.nextFloat());
                System.out.println("Resultado: " + cd.somar());
                break;

            case 2:
                System.out.println("Digite o primeiro valor: ");
                cd.setA(sc.nextFloat());
                System.out.println("Digite o segundo valor: ");
                cd.setB(sc.nextFloat());
                System.out.println("Resultado: " + cd.subtrair());
                break;

            case 3:
                System.out.println("Digite o primeiro valor: ");
                cd.setA(sc.nextFloat());
                System.out.println("Digite o segundo valor: ");
                cd.setB(sc.nextFloat());
                System.out.println("Resultado: " + cd.divisao());
                break;
            case 4:
                System.out.println("Digite o primeiro valor: ");
                cd.setA(sc.nextFloat());
                System.out.println("Digite o segundo valor: ");
                cd.setB(sc.nextFloat());
                System.out.println("Resultado: " + cd.multiplicacao());
                break;
            case 5:
                System.out.println("Digite o valor que queira saber o seu quadrado: ");
                cd.setA(sc.nextFloat());
                System.out.println("Resultado: " + cd.quadrado());
            default:
                System.out.println("Opção inválida");
                return;
        }
    }
}
