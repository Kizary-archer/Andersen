package ProductBuilders;

public interface Builder<T> {

    public void setManufactore(String manufacture);
    public void setModel(String model);
    public void setPrise(int prise);
    public T build();
}
