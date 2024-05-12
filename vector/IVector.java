public interface IVector {
  public Object elementAtRank(int rank);
  public Object replaceAtRank( int rank, Object element);
  public void insertAtRank(int rank, Object element);
  public Object removeAtRank(int rank);
  public boolean isEmpty();
  public int sizeInsert();
}
