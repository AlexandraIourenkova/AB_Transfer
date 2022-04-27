package alphaBank.transfer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import alphaBank.transfer.model.TransferEntity;

public interface TransferMoneyRepository extends MongoRepository<TransferEntity, String> {

}
