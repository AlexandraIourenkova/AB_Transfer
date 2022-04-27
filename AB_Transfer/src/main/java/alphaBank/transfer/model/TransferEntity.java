package alphaBank.transfer.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransferEntity {
	@Id
	String transferId;
	String senderId;
	String receiverId;
	int sum;
	Boolean transactionApproved;
	Boolean amlApproved;
	Boolean ataApproved;

}
