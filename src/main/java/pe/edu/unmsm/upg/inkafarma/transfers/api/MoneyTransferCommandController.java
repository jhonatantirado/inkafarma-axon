package pe.edu.unmsm.upg.inkafarma.transfers.api;

import pe.edu.unmsm.upg.inkafarma.transfers.application.dto.MoneyTransferErrorResponseDto;
import pe.edu.unmsm.upg.inkafarma.transfers.application.dto.MoneyTransferOkResponseDto;
import pe.edu.unmsm.upg.inkafarma.transfers.application.dto.MoneyTransferRequestDto;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import pe.edu.unmsm.upg.inkafarma.transfers.messages.commands.*;

@RestController
@RequestMapping("/transfers")
public class MoneyTransferCommandController {
	private final CommandGateway commandGateway;
	
	public MoneyTransferCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
	
	@PostMapping("")
	public CompletableFuture<Object> transfer(@Validated @RequestBody MoneyTransferRequestDto moneyTransferRequestDto) {
		String transactionId = UUID.randomUUID().toString();
		RequestMoneyTransferCommand command = new RequestMoneyTransferCommand(
			transactionId,
			moneyTransferRequestDto.getSourceAccountId(),
			moneyTransferRequestDto.getDestinationAccountId(),
			moneyTransferRequestDto.getAmount()
		);
		CompletableFuture<Object> future = commandGateway.send(command);
		CompletableFuture<Object> response = future.handle((ok, ex) -> {
		    if (ex != null) {
		    	ex.printStackTrace();
		        return new MoneyTransferErrorResponseDto();
		    }
		    return new MoneyTransferOkResponseDto(transactionId);
		});
		return response;
	}
}