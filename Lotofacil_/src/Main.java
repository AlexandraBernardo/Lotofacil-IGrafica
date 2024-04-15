import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Random;

class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int opcao;

        do {
            System.out.println(" LOTOFÁCIL ");
            System.out.println("1- Aposta de 0 a 100");
            System.out.println("2- Aposta de A a Z");
            System.out.println("3- Aposta em par ou impar");
            System.out.println("0- Sair");
            System.out.println("Escolha a opção desejada : ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    apostade0a100(scanner, random);
                    break;

                case 2:
                    apostadeAaZ(scanner);
                    break;

                case 3:
                    Apostaemparouimpar(scanner, random);
                    break;

                case 0:
                    System.out.println("Digite 0 para sair");
                    break;

                default:
                    System.out.println("opção invalida");
            }
        } while (opcao != 0);
    }

    private static void Apostaemparouimpar(Scanner scanner, Random random) {

    }

    private static void apostadeAaZ(Scanner scanner) {
    }


    private static void apostade0a100(Scanner scanner, Random random) {

    }


    public static class Main extends JFrame{
        // Atributos
        private JPanel painel = new JPanel();
        private JButton jButtonAposta1 = new JButton("Apostar de 0 a 100");
        private JButton jButtonAposta2 = new JButton("Apostar de A a Z");
        private JButton jButtonAposta3 = new JButton("Apostar par ou ímpar");
        private JLabel jLabelMensagem = new JLabel("Exemplo de Simples Janela");
        // Construtor
        public Main(){
            this.setTitle("Lotofácil - Interface Gráfica");
            this.setSize(400,200);
            painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
            painel.setBackground(new Color(255,255,255));
            painel.add(jButtonAposta1);
            painel.add(jButtonAposta2);
            painel.add(jButtonAposta3);
            jButtonAposta1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String aposta1 = JOptionPane.showInputDialog(null,"Digite um número de 0 a 100: ");
                    Random rnd = new Random();
                    int sorteio = rnd.nextInt(101);
                    int numeroApostado = Integer.parseInt(aposta1);
                    if(numeroApostado == sorteio){
                        JOptionPane.showMessageDialog(null,"Você ganhou!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Você perdeu! O número sorteado foi: " + sorteio);
                    }
                }
            });
            jButtonAposta2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String aposta2 = JOptionPane.showInputDialog(null,"Digite uma letra de A à Z: ");
                    char letraSorteada = 'V';
                    char letraApostada = aposta2.charAt(0);
                    if(Character.isLetter(letraApostada)){
                        char letraApostadaMaiusculo = Character.toUpperCase(letraApostada);
                        if(letraApostadaMaiusculo == letraSorteada){
                            JOptionPane.showMessageDialog(null,"Você ganhou quinhentão.\n");
                        }else {
                            JOptionPane.showMessageDialog(null,"Você perdeu!, a letra sorteada foi: " + letraSorteada + "\n");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Não é uma letra válida.");
                    }

                }
            });
            jButtonAposta3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String aposta3 = JOptionPane.showInputDialog(null,"Digite um número: ");
                    int numeroApostado = Integer.parseInt(aposta3);
                    if(numeroApostado % 2 == 0){
                        JOptionPane.showMessageDialog(null,"Você ganhou cenzão.");
                    }else{
                        JOptionPane.showMessageDialog(null,"Você perdeu!");
                    }
                }
            });
            this.getContentPane().add(painel);
            this.setLocationRelativeTo(null); // Centralizar janela
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setVisible(true); // Exibir janela
        }
        public static void main(String[] args) {
            new Main();

        }

    }
}