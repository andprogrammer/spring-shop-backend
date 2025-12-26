curl -X POST "http://localhost:8080/shop/products?name=Laptop&price=899.99" \
     -H "Content-Type: application/json"

curl -X POST "http://localhost:8080/shop/products?name=Smartphone&price=499.99" \
     -H "Content-Type: application/json"

curl -X GET "http://localhost:8080/shop/products"
