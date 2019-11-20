# inkafarma-axon
inkafarma with Axon 4.2 & Spring Boot 2.2.0 & Webflux

#Apis

#http://localhost:8085/sales
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


#http://localhost:8085/sales/findById/febfd544-c61e-4111-bb1c-311127bd0d0f

WebFlux
#http://localhost:8085/sales/findByMono/febfd544-c61e-4111-bb1c-311127bd0d0f
#http://localhost:8085/sales/allFlux