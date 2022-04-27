package alphaBank.transfer.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import alphaBank.transfer.dto.ForApprovalTransferDto;
import alphaBank.transfer.dto.TransferMoneyDto;
import alphaBank.transfer.model.TransferEntity;
import alphaBank.transfer.repository.TransferMoneyRepository;

@Service
public class TransfMoneyServiceImpl implements ITransferMoneyService {

	ModelMapper modelMapper;
	TransferMoneyRepository transferMoneyRepository;
	StreamBridge streamBridge;
	

	@Autowired
	public TransfMoneyServiceImpl(ModelMapper modelMapper, TransferMoneyRepository repository,
			StreamBridge streamBridge) {
		this.modelMapper = modelMapper;
		this.transferMoneyRepository = repository;
		this.streamBridge = streamBridge;
		
	}

	@Override
	public ForApprovalTransferDto transferMoney(TransferMoneyDto transferMoneyDto) { // sends message
		TransferEntity transferEntity = modelMapper.map(transferMoneyDto, TransferEntity.class);
		transferMoneyRepository.save(transferEntity);
		ForApprovalTransferDto forApprovelTransferDto = modelMapper.map(transferEntity, ForApprovalTransferDto.class);
		System.out.println(streamBridge.send("alexandradata-out-0", forApprovelTransferDto));
		

		System.out.println(transferMoneyDto);
		System.out.println(forApprovelTransferDto);

		return forApprovelTransferDto;

	}

//	@Bean
//	Consumer<ResponseTransferMoneyDto> closeTransfer() {
//		return this::finishTransfer;
//	}
//
//	private void finishTransfer(ResponseTransferMoneyDto responseTransferMoneyDto) {
//		TransferEntity transferEntity = transferMoneyRepository.findById(responseTransferMoneyDto.getTransferId())
//				.orElseThrow(() -> new TransferNotFoundException());
//		transferEntity.setTransactionApproved(responseTransferMoneyDto.isTransactionApproved());
//		transferMoneyRepository.save(transferEntity);
//		if (responseTransferMoneyDto.isTransactionApproved()) {
//			AccountEntity user = accountMongoRepository.findById(responseTransferMoneyDto.getSenderId())
//					.orElseThrow(() -> new UserNotFoundException());
//			user.credit(responseTransferMoneyDto.getSum());
//			accountMongoRepository.save(user);
//			AccountEntity user2 = accountMongoRepository.findById(responseTransferMoneyDto.getReceiverId())
//					.orElseThrow(() -> new UserNotFoundException());
//			user2.debit(responseTransferMoneyDto.getSum());
//			accountMongoRepository.save(user2);
//		}
//	}
}
