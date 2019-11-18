package pe.edu.unmsm.upg.inkafarma.sales.api;

import pe.edu.unmsm.upg.inkafarma.sales.application.dto.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import pe.edu.unmsm.upg.inkafarma.sales.messages.commands.*;

@RestController
@RequestMapping("/sales")
public class SalesOrderCommandController {

	private final CommandGateway commandGateway;
	
	public SalesOrderCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
	
	@PostMapping("")
	public CompletableFuture<Object> saleOrder(@Validated @RequestBody SalesOrderRequestDto salesRequestDto) {
		String salesId = UUID.randomUUID().toString();
		RequestSalesOrderCommand command = new RequestSalesOrderCommand(
			salesId,
			salesRequestDto.getCustomerId(),
			salesRequestDto.getEmployeeId(),
			salesRequestDto.getDetails()
		);
		CompletableFuture<Object> future = commandGateway.send(command);
		CompletableFuture<Object> response = future.handle((ok, ex) -> {
		    if (ex != null) {
		    	ex.printStackTrace();
		        return new SalesOrderErrorResponseDto();
		    }
		    return new SalesOrderOkResponseDto(salesId);
		});
		return response;
	}
}
