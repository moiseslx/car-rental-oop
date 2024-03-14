package tech.ada.rental.repository;

public interface Repository <T>{

    T save(T t);
    T findById(Long id);
    void deleteById(Long id);
    Iterable<T> findAll();

}
