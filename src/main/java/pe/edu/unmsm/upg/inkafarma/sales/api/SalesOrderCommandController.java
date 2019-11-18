package pe.edu.unmsm.upg.inkafarma.sales.api;

import pe.edu.unmsm.upg.inkafarma.sales.application.dto.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import pe.edu.unmsm.upg.inkafarma.sales.messages.commands.*;
import pe.edu.unmsm.upg.inkafarma.sales.query.SalesView;
import pe.edu.unmsm.upg.inkafarma.sales.query.SalesViewRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.upg.inkafarma.common.application.ApiResponseHandler;

@RestController
@RequestMapping("/sales")
public class SalesOrderCommandController {

	@Autowired
	ApiResponseHandler apiResponseHandler;
	@Autowired
	SalesViewRepository salesViewRepository;
	
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
	
	@GetMapping("findById/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        try {
            return new ResponseEntity<Object>(salesViewRepository.findOneBySalesId(id), HttpStatus.OK);
        } catch(IllegalArgumentException ex) {
        	return new ResponseEntity<Object>(apiResponseHandler.getApplicationError(ex.getMessage()), HttpStatus.BAD_REQUEST);
        } catch(Exception ex) {
        	return new ResponseEntity<Object>(apiResponseHandler.getApplicationException(), HttpStatus.INTERNAL_SERVER_ERROR);
        }        
    }
	
	@GetMapping("findByMono/{id}")
    public ResponseEntity<Object> findByIdMono(@PathVariable String id) {
		 try {
	            return new ResponseEntity<Object>(salesViewRepository.findOneBySalesId(id), HttpStatus.OK);
	        } catch(IllegalArgumentException ex) {
	        	return new ResponseEntity<Object>(apiResponseHandler.getApplicationError(ex.getMessage()), HttpStatus.BAD_REQUEST);
	        } catch(Exception ex) {
	        	return new ResponseEntity<Object>(apiResponseHandler.getApplicationException(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }   
    }
}
