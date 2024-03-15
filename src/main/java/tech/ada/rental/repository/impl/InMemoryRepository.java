package tech.ada.rental.repository.impl;

import tech.ada.rental.model.IdBasedModel;
import tech.ada.rental.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryRepository<T extends IdBasedModel> implements Repository<T> {
        protected List<T> objetos = new ArrayList<>();

        Long idContador = 0L;

        @Override
        public T findById(Long id) {
            return objetos.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
        }

        @Override
        public List<T> findAll() {
            return objetos;
        }

        @Override
        public void deleteById(Long id) {
            objetos.remove(findById(id));
        }
        @Override
        public T save(T o) {
            if (o.getId() == null) {
                o.setId(idContador);
                idContador = idContador + 1;
                objetos.add(o);
            } else {
                T objetoToUpdate = findById(o.getId());
                objetos.remove(objetoToUpdate);
                objetoToUpdate.setId(o.getId());
                objetos.add(o);
            }
            return o;
        }
    }


