package structure.customlist;

public interface GBList extends GBIterable {
    void add(String val);

    boolean remove(String val);

    String get (int index);

    int size();
}

