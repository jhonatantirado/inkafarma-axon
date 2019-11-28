# inkafarma-axon
inkafarma with Axon 4.2 & Spring Boot 2.2.0 & Webflux

## Apis

@PostMapping("")
## http://localhost:8085/sales
```json
{
	"customerId":2,
	"details":[
		      {
				"detailId":"",
				"saleId":"",
				"productId": 1,
				"quantity":20,
				"price": 5.0,
				"currency":"PEN",
				"status": 1
	           },
	            {
				"detailId":"",
				"saleId":"",
				"productId": 2,
				"quantity":50,
				"price": 12.0,
				"currency":"PEN",
				"status": 1
	           }
	          ]
}
```

@GetMapping("findById/{id}")
## http://localhost:8085/sales/findById/?



##WebFlux


@GetMapping("findByMono/{id}")
##http://localhost:8085/sales/findByMono/?


@RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE, path = "/allFlux")
##http://localhost:8085/sales/allFlux