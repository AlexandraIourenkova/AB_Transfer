package alphaBank.transfer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTransferMoneyDto {
	String transferId;
	String senderId;
	String receiverId;
	int sum;
	boolean transactionApproved;
	String approvementId;

}
