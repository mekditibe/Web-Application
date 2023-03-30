package edu.miu.calculator;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends ReactiveCrudRepository<Operation, String > {

}
