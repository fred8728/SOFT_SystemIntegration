## Assignment 4 - Camunda
### Group members:
Frederikke Simone Koefoed Nilsson 
### Proces flow diagram
[Diagram](https://github.com/fred8728/SOFT_SystemIntegration/blob/master/MiniProject4/ApplicationProcessFlow.PNG)
### Docker
```
docker run -d --name camunda -p 8080:8080 camunda/camunda-bpm-platform:latest
```
### Postman 
Use postman to send POST-request.
 
```
Endpoint: http://localhost:8081/send

{
    "name": "Frederikke Nilsson",
    "income": 1200000,
    "bank": "Danske Bank",
    "amount": 30000,
    "termin": 12,
    "type": "In job"
}
```
