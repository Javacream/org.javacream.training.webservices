curl -verbose -X GET -H "Accept: text/html" http://integrata-cegos.de


curl -verbose -X GET -H "Accept: text/plain" http://localhost:8080/api/ping

curl -verbose -X GET -H "Accept: text/plain" http://localhost:8080/api/echo

Paramaterübergabe

1. curl -verbose -X GET -H "Accept: text/plain" http://localhost:8080/api/echo/hello (PATH-Parameter)
2. curl -verbose -X GET -H "Accept: text/plain" http://localhost:8080/api/echo?message=hello (Query-Parameter)
3. curl -verbose -X GET -H "Accept: text/plain"  -H "message: Hello" http://localhost:8080/api/echo/header (Header-Parameter)
4. curl -verbose -d "Hello" -X GET -H "Accept: text/plain" http://localhost:8080/api/echo (Body)


curl -X GET http://localhost:8080/api/store/books/ISBN1
curl -X GET http://localhost:8080/api/store/dvd/StarTrek
curl -X GET "http://localhost:8080/api/store/query?category=dvd&item=StarTrek"
curl -X GET -H "CATEGORY: dvd" -H "ID: StarTrek" "http://localhost:8080/api/store/header"


# Books

curl -X POST http://localhost:8080/api/books/Spring
curl -X POST http://localhost:8080/api/books/JEE

curl -X GET http://localhost:8080/api/books/ISBN1
curl -X DELETE http://localhost:8080/api/books/ISBN1

curl -X PUT -H "Content-Type: application/json" -d@update.json http://localhost:8080/api/books/ISBN2

# IdGenerator

curl -X POST http://localhost:8080/api/id

# OptimizedStore

curl -X PUT -H "Content-Type: application/json" -d@storeRequest.json http://localhost:8080/api/store/books

# NonTrivialBooksWebService

curl -X GET http://localhost:8080/api/books/nontrivial
curl -X GET http://localhost:8080/api/books/nontrivial?maxSize=3
curl -X GET http://localhost:8080/api/books/nontrivial/ISBN1
