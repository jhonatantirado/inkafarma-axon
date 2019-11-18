package pe.edu.unmsm.upg.inkafarma.accounts.api;

import pe.edu.unmsm.upg.inkafarma.customers.query.CustomerView;
import pe.edu.unmsm.upg.inkafarma.customers.query.CustomerViewRepository;
import pe.edu.unmsm.upg.inkafarma.accounts.application.dto.DepositMoneyRequestDto;
import pe.edu.unmsm.upg.inkafarma.accounts.application.dto.EditAccountOkResponseDto;
import pe.edu.unmsm.upg.inkafarma.accounts.application.dto.EditAccountRequestDto;
import pe.edu.unmsm.upg.inkafarma.accounts.application.dto.DepositMoneyErrorResponseDto;
import pe.edu.unmsm.upg.inkafarma.accounts.application.dto.OpenAccountOkResponseDto;
import pe.edu.unmsm.upg.inkafarma.accounts.application.dto.WithdrawMoneyOkResponseDto;
import pe.edu.unmsm.upg.inkafarma.accounts.application.dto.WithdrawMoneyErrorResponseDto;
import pe.edu.unmsm.upg.inkafarma.accounts.application.dto.WithdrawMoneyRequestDto;
import pe.edu.unmsm.upg.inkafarma.accounts.application.dto.DepositMoneyOkResponseDto;
import pe.edu.unmsm.upg.inkafarma.accounts.application.dto.EditAccountErrorResponseDto;
import pe.edu.unmsm.upg.inkafarma.accounts.application.dto.OpenAccountErrorResponseDto;
import pe.edu.unmsm.upg.inkafarma.accounts.application.dto.OpenAccountRequestDto;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import pe.edu.unmsm.upg.inkafarma.accounts.messages.commands.DepositMoneyCommand;
import pe.edu.unmsm.upg.inkafarma.accounts.messages.commands.EditAccountCommand;
import pe.edu.unmsm.upg.inkafarma.accounts.messages.commands.OpenAccountCommand;
import pe.edu.unmsm.upg.inkafarma.accounts.messages.commands.WithdrawMoneyCommand;

@RestController
@RequestMapping("/accounts")
public class AccountCommandController {
	private final CommandGateway commandGateway;
	private final CustomerViewRepository customerIdRepository;
	
	public AccountCommandController(CommandGateway commandGateway, CustomerViewRepository customerIdRepository) {
        this.commandGateway = commandGateway;
        this.customerIdRepository = customerIdRepository;
    }
	
	@PostMapping("")
	public CompletableFuture<Object> open(@Validated @RequestBody OpenAccountRequestDto openAccountRequestDto) {
		String accountId = UUID.randomUUID().toString();
		Optional<CustomerView> customerId = customerIdRepository.findById(openAccountRequestDto.getCustomerId());
		if (!customerId.isPresent()) {
			return CompletableFuture.supplyAsync(
				() -> {
					return new OpenAccountErrorResponseDto();
				}
			);
		}
		OpenAccountCommand openAccountCommand = new OpenAccountCommand(
			accountId,
			openAccountRequestDto.getOverdraftLimit(),
			openAccountRequestDto.getCustomerId()
		);
		CompletableFuture<Object> future = commandGateway.send(openAccountCommand);
		CompletableFuture<Object> response = future.handle((ok, ex) -> {
		    if (ex != null) {
		    	ex.printStackTrace();
		        return new OpenAccountErrorResponseDto();
		    }
		    return new OpenAccountOkResponseDto(
		    	accountId
			);
		});
		return response;
	}
	
	@PutMapping("/{accountId}")
	public CompletableFuture<Object> edit(
			@PathVariable("accountId") String accountId,
			@RequestBody EditAccountRequestDto editAccountDto) {
		editAccountDto.setAccountId(accountId);
		EditAccountCommand editAccountCommand = new EditAccountCommand(
			editAccountDto.getAccountId(),
			editAccountDto.getOverdraftLimit());
		CompletableFuture<Object> future = commandGateway.send(editAccountCommand);
		CompletableFuture<Object> response = future.handle((ok, ex) -> {
		    if (ex != null) {
		    	ex.printStackTrace();
		        return new EditAccountErrorResponseDto();
		    }
		    return new EditAccountOkResponseDto(
				accountId
			);
		});
		return response;
	}
	
	@PostMapping("/deposit")
	public CompletableFuture<Object> deposit(@Validated @RequestBody DepositMoneyRequestDto depositMoneyRequestDto) {
		String transactionId = UUID.randomUUID().toString();
		DepositMoneyCommand command = new DepositMoneyCommand(
			depositMoneyRequestDto.getAccountId(),
			transactionId,
			depositMoneyRequestDto.getAmount()
		);
		CompletableFuture<Object> future = commandGateway.send(command);
		CompletableFuture<Object> response = future.handle((ok, ex) -> {
		    if (ex != null) {
		    	ex.printStackTrace();
		        return new DepositMoneyErrorResponseDto();
		    }
		    return new DepositMoneyOkResponseDto(transactionId);
		});
		return response;
	}
	
	@PostMapping("/withdraw")
	public CompletableFuture<Object> withdraw(@Validated @RequestBody WithdrawMoneyRequestDto withdrawMoneyRequestDto) {
		String transactionId = UUID.randomUUID().toString();
		WithdrawMoneyCommand command = new WithdrawMoneyCommand(
			withdrawMoneyRequestDto.getAccountId(),
			transactionId,
			withdrawMoneyRequestDto.getAmount()
		);
		CompletableFuture<Object> future = commandGateway.send(command);
		CompletableFuture<Object> response = future.handle((ok, ex) -> {
		    if (ex != null) {
		    	ex.printStackTrace();
		        return new WithdrawMoneyErrorResponseDto();
		    }
		    return new WithdrawMoneyOkResponseDto(transactionId);
		});
		return response;
	}
}