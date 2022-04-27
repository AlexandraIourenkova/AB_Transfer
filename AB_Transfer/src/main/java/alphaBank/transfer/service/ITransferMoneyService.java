package alphaBank.transfer.service;

import alphaBank.transfer.dto.ForApprovalTransferDto;
import alphaBank.transfer.dto.TransferMoneyDto;

public interface ITransferMoneyService {

	public ForApprovalTransferDto transferMoney(TransferMoneyDto transferMoneyDto);

}
