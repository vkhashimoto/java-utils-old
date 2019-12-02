public class Dias {

  static String[] DIAS = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};

  public static void main(String[] args) {
    StringBuilder text = new StringBuilder();
    int[] dias = {};
    int index = 0;
    int currentIndex = index;
    while (index < dias.length) {
      index = findNextIndexStart(dias, index);
      if (index - currentIndex == 0) {
        if (!text.toString().isEmpty())
          text.append(", ");
        text.append(DIAS[dias[index]]);
      } else if ((index - currentIndex) <= 1) {
        if (!text.toString().isEmpty())
          text.append(", ");
        text.append(DIAS[dias[currentIndex]] + ", " + DIAS[dias[index]]);
      } else {
        if (!text.toString().isEmpty())
          text.append(", ");
        text.append(DIAS[dias[currentIndex]] + " à " + DIAS[dias[index]]);
      }
      currentIndex = index + 1;
      index += 1;
    }
    String finalText = text.toString();
    int lastCommaPosition = finalText.lastIndexOf(",");
    int lastAPosition = finalText.lastIndexOf("à");

    if (lastCommaPosition != -1 && (finalText.chars().filter(ch -> ch == ',').count() > 1
        || lastCommaPosition > lastAPosition))
      finalText = finalText.substring(0, lastCommaPosition) + " e"
          + finalText.substring(lastCommaPosition + 1);
    System.out.println(finalText);
  }

  public static int findNextIndexStart(int[] dias, int indexStart) {
    if (indexStart == dias.length - 1)
      return indexStart;
    if (indexStart == dias.length)
      return indexStart - 1;
    if (dias[indexStart + 1] == dias[indexStart] + 1)
      return findNextIndexStart(dias, indexStart + 1);
    else
      return indexStart;
  }

}
