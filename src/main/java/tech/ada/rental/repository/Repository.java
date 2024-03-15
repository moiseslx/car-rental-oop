package tech.ada.rental.repository;

import java.util.List;

public interface Repository <T>{

    T save(T t);
    T findById(Long id);
    void deleteById(Long id);
    List<T> findAll();

}
