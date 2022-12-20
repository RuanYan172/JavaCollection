package service;

import java.util.List;

public interface BasicOperator<T> {
    List<T> getAllData();

    T getDataById(int id);

    T addData(T data) throws Exception;

    T updateData(T data);

    T removeDataById(int id);
}
