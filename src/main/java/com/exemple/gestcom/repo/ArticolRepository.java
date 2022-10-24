package com.exemple.gestcom.repo;

import com.exemple.gestcom.models.articole;
import org.springframework.data.repository.CrudRepository;

public interface ArticolRepository extends CrudRepository<articole, Long> {
}
