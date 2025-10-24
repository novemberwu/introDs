package LabDLList;

public interface DLList <Type>{
    void addFirst(Type item);
    void addLast(Type item);
    Type get(int pos);
    Type getFirst();
    Type getLast();
    Type removeFirst();
    Type removeLast();
    int size();
}
