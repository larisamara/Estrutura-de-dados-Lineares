class Main {
  public static void main(String[] args) {
    IVector vector = new Vector(10);
    vector.insertAtRank(1, "Larissa");
    Object firstElement  = vector.elementAtRank(1);   
    System.out.println(firstElement);
    vector.insertAtRank(2, "Samara");
    Object secondElement  = vector.elementAtRank(2);   
    System.out.println(secondElement);
    vector.replaceAtRank(2, "Lima");
    System.out.println(vector.elementAtRank(2));
    vector.removeAtRank(1);
    System.out.println(vector.elementAtRank(1));
    System.out.println(vector.elementAtRank(2));
    System.out.println(vector.sizeInsert());
    System.out.println(vector.isEmpty());
  }
}
