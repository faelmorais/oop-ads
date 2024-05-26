package unidade_3;

public class ImcResult {
  public final double IMC;
  public final String classification;

  public ImcResult(double height, double weight) {
    IMC = weight / (height * height);
    classification = getClassification();
  }

  private String getClassification() {
    if (IMC < 17) {
      return "Muito abaixo do peso";
    } else if (IMC < 18.49) {
      return "Abaixo do peso";
    } else if (IMC < 25.99) {
      return "Peso normal";
    } else if (IMC < 34.99) {
      return "Obesidade I";
    } else if (IMC < 39.99) {
      return "Obesidade II";
    } else {
      return "Obesidade III";
    }
  }
}
