# Money transfer API
Implementation of a RESTful API for money transfers between accounts.
##Overview
Design and implement a RESTful API (including data model and the backing implementation) for
money transfers between accounts.

   - JAX-RS API
   - H2 in memory database
   - Jetty Container (for Test and Demo app)
   - Log4j

### Build and run app
`./gradlew clean build && java -jar build/libs/money-transfer.jar `

### API usage description
**`/accounts`**
  - *POST* - add new account 
      "http://localhost:5000/account


