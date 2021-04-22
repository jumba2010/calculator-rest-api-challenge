# calculator-rest-api-challenge
This is a Spring boot rest api for simple calculator using RabbitMq and Spring AMQP
To run It, first you neet to install java 8 or greater
Then run calculator.api.core as normal java application
Afterwards run calculatro.api.rest
The you go to the Brouser or use tools like postman or other to test the endpoints
the base endpoint is /api/v1/calculators
You can try GET with three pathVariables @var1=20, @var2=2, operation=add
Ex. http://localhost:8080/api/v1/calculators/20/2/add
