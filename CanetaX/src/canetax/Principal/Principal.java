package canetax.Principal;

import canetax.Caneta;
import javax.swing.JOptionPane;

public class Principal {


    public static void main(String[] args) {
        Caneta c1 = new Caneta();
        
        //Entrada de Dados
        c1.modelo = JOptionPane.showInputDialog("Informe o modelo: ");
        c1.cor = JOptionPane.showInputDialog("Informe a cor da tinta: ");
        c1.carga = Integer.parseInt(JOptionPane.showInputDialog("Informe a qtde da carga (%): "));
        c1.ponta = Double.parseDouble(JOptionPane.showInputDialog("Informe a espessura da ponta: "));
        
        
        Caneta c2 = new Caneta();
        
        //Entrada de Dados
        c2.modelo = JOptionPane.showInputDialog("Informe o modelo: ");
        c2.cor = JOptionPane.showInputDialog("Informe a cor da tinta: ");
        c2.carga = Integer.parseInt(JOptionPane.showInputDialog("Informe a qtde da carga (%): "));
        c2.ponta = Double.parseDouble(JOptionPane.showInputDialog("Informe a espessura da ponta: "));
        
        //Processamento
        System.out.println("Caneta 1: " + c1.escrever());
        
        
        System.out.println("Caneta 2: " + c2.pintar());
        
        //Saída
        System.out.println(c1);
        
        System.out.println(c2);
    }
}
