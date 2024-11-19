/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author aula9
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Parqueadero;

public class GUI {
    private JFrame frame;
    private JSpinner spinnerHoras; // Cambiado a JSpinner
    private JComboBox<String> comboTipoCarro;
    private JTextArea txtResultado;
    private JCheckBox chkLavado;

    public GUI() {
        frame = new JFrame("Servicio de Parqueadero y Lavado");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel lblHoras = new JLabel("Horas de parqueo:");
        lblHoras.setBounds(20, 20, 150, 25);
        frame.add(lblHoras);

        // Crear JSpinner para seleccionar las horas de parqueo
        spinnerHoras = new JSpinner(new SpinnerNumberModel(1, 1, 24, 1)); // Rango de 1 a 24 horas
        spinnerHoras.setBounds(150, 20, 50, 25);
        frame.add(spinnerHoras);

        JLabel lblTipoCarro = new JLabel("Tipo de carro:");
        lblTipoCarro.setBounds(20, 60, 250, 25);
        frame.add(lblTipoCarro);

        // Crear JComboBox para seleccionar el tipo de carro
        String[] tiposCarro = {"automovil", "campero"};
        comboTipoCarro = new JComboBox<>(tiposCarro);
        comboTipoCarro.setBounds(150, 60, 200, 25);
        frame.add(comboTipoCarro);

        chkLavado = new JCheckBox("Incluir servicio de lavado");
        chkLavado.setBounds(20, 100, 250, 25);
        frame.add(chkLavado);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 130, 100, 25);
        frame.add(btnCalcular);

        txtResultado = new JTextArea();
        txtResultado.setBounds(20, 170, 340, 100);
        txtResultado.setEditable(false);
        frame.add(txtResultado);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularValor();
            }
        });

        frame.setVisible(true);
    }

    private void calcularValor() {
        int horas = (int) spinnerHoras.getValue(); // Obtener el valor del JSpinner
        String tipoCarro = (String) comboTipoCarro.getSelectedItem(); // Obtener el tipo de carro del JComboBox
        boolean conLavado = chkLavado.isSelected();

        Parqueadero parqueadero = new Parqueadero(horas, tipoCarro, conLavado);
        String resultado = parqueadero.calcularValores();

        txtResultado.setText(resultado);
    }

    public static void main(String[] args) {
        new GUI();
    }
}