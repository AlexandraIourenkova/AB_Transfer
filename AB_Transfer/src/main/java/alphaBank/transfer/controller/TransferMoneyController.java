package alphaBank.transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alphaBank.transfer.dto.ForApprovalTransferDto;
import alphaBank.transfer.dto.TransferMoneyDto;
import alphaBank.transfer.service.ITransferMoneyService;

@RestController
@RequestMapping("/alphaBank")

public class TransferMoneyController {

	ITransferMoneyService service;

	@Autowired
	public TransferMoneyController(ITransferMoneyService service) {
		this.service = service;
	}

	@PostMapping("/transferMoney")
	public ForApprovalTransferDto transferMoney(@RequestBody TransferMoneyDto transferMoneyDto) {
		return service.transferMoney(transferMoneyDto);
	}

}
