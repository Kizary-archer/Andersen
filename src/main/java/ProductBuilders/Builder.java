package ProductBuilders;

public interface Builder<T> {

    public void setModel(String model);
    public void setPrise(int prise);
    public T build();
}
