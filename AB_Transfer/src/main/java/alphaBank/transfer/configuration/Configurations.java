package alphaBank.transfer.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import alphaBank.transfer.dto.TransferMoneyDto;


@Configuration
public class Configurations {
	
	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
			.setFieldMatchingEnabled(true)
			.setFieldAccessLevel(AccessLevel.PRIVATE)
			.setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

//	@Bean
//	public TransferMoneyDto getTransferMoneyDto() {
//		TransferMoneyDto transferMoneyDto = new TransferMoneyDto();
//		return transferMoneyDto;
//	}
}
