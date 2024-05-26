package unidade_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Imc implements ActionListener {
  private final JFrame frame;
  private final GridBagConstraints constraints;
  private JLabel resultLabel;
  private JLabel classificationLabel;
  private JTextField heightField;
  private JTextField weightField;

  public Imc() {
    this.frame = Imc.createFrame();
    this.constraints = Imc.createConstraints();
    this.initLayout();
  }

  public static void main(String[] args) {
    new Imc();
  }

  private void initLayout() {
    heightField = Imc.createTextField(0, "Altura (m):", this.frame, this.constraints);
    weightField = Imc.createTextField(1, "Peso (Kg):", this.frame, this.constraints);

    JButton calculateButton = new JButton("Calcular IMC");
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.gridwidth = 2;
    calculateButton.addActionListener(this);
    frame.add(calculateButton, constraints);

    resultLabel = Imc.createLabel(3, "Seu IMC: ", frame, constraints);
    classificationLabel = Imc.createLabel(4, "Classificação: ", frame, constraints);

    frame.setVisible(true);
  }

  private static JFrame createFrame() {
    JFrame frame = new JFrame("Calculadora de IMC");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setLocationRelativeTo(null);
    frame.setLayout(new GridBagLayout());
    return frame;
  }

  private static GridBagConstraints createConstraints() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    return gbc;
  }

  private static JTextField createTextField(int gridY, String label, JFrame frame, GridBagConstraints gbc) {
    JLabel textFieldLabel = new JLabel(label);
    gbc.gridx = 0;
    gbc.gridy = gridY;
    frame.add(textFieldLabel, gbc);

    JTextField textField = new JTextField(10);
    gbc.gridx = 1;
    gbc.gridy = gridY;
    frame.add(textField, gbc);

    return textField;
  }

  private static JLabel createLabel(int gridY, String label, JFrame frame, GridBagConstraints gbc) {
    JLabel textLabel = new JLabel(label);
    gbc.gridx = 0;
    gbc.gridy = gridY;
    gbc.gridwidth = 2;
    frame.add(textLabel, gbc);
    return textLabel;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      double height = Double.parseDouble(this.heightField.getText());
      double weight = Double.parseDouble(weightField.getText());

      ImcResult imcResult = new ImcResult(height, weight);

      resultLabel.setText(String.format("Seu IMC: %.2f", imcResult.IMC));
      classificationLabel.setText("Classificação: " + imcResult.classification);
    } catch (NumberFormatException ex) {
      resultLabel.setText("Por favor, insira valores válidos.");
      classificationLabel.setText("Classificação: ");
    }
  }
}
