package Lotofácil;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Lotofacil extends JFrame {
    // Atributos
    private JPanel painel = new JPanel();
    private JButton jButtonAposta2 = new JButton("Apostar de 0 a 100");
    private JButton jButtonAposta3 = new JButton("Apostar de A a Z");
    private JButton jButtonAposta1 = new JButton("Apostar par ou ímpar");
    private JLabel jLabelMensagem = new JLabel("Lotofácil");

    // Construtor
    public Lotofacil() {
        this.setTitle("Lotofácil - Interface Gráfica");
        this.setSize(400, 200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255, 255, 255));
        painel.add(jButtonAposta2);
        painel.add(jButtonAposta3);
        painel.add(jButtonAposta1);

        jButtonAposta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100: ");
                try {
                    int numeroApostado = Integer.parseInt(aposta);
                    Random rnd = new Random();
                    int sorteio = rnd.nextInt(101);
                    if (numeroApostado == sorteio) {
                        JOptionPane.showMessageDialog(null, "Você ganhou!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Você perdeu! O número sorteado foi: " + sorteio);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, insira um número válido.");
                }
            }
        });

        jButtonAposta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta = JOptionPane.showInputDialog(null, "Digite uma letra de A à Z: ");
                if (aposta != null && !aposta.isEmpty()) {
                    char letraSorteada = (char) ('A');
                    char letraApostada = aposta.toUpperCase().charAt(0);
                    if (Character.isLetter(letraApostada)) {
                        if (letraApostada == letraSorteada) {
                            JOptionPane.showMessageDialog(null, "Você ganhou! A letra sorteada foi: " + letraSorteada);
                        } else {
                            JOptionPane.showMessageDialog(null, "Você perdeu! A letra sorteada foi: " + letraSorteada);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Não é uma letra válida.");
                    }
                }
            }
        });

        jButtonAposta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta = JOptionPane.showInputDialog(null, "Digite um número: ");
                try {
                    int numeroApostado = Integer.parseInt(aposta);
                    if (numeroApostado % 2 == 0) {
                        JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Você perdeu!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, insira um número válido.");
                }
            }
        });

        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir janela
    }

    public static void main(String[] args) {
        new Lotofacil();
    }
}