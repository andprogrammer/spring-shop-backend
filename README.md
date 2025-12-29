# shop-backend
Backend service that manages products for an online store.

---

## System Requirements

- **Operating System**: Tested on Ubuntu 24.04.3 LTS (or newer).
- **Java Version**: JDK 21 (or later). You can install it using the instructions below.

## Repository
```bash
git clone git@github.com:andprogrammer/spring-shop-backend.git
```

## Docker
```bash
docker build -t spring-shop-backend .
```

```bash
docker run -d -p 8080:8080 --name spring-shop-backend-container spring-shop-backend
```

http://localhost:8080/shop

```bash
docker stop spring-shop-backend-container
```

```bash
docker rm spring-shop-backend-container
```

## Kubernetes
```bash
minikube start
eval $(minikube -p minikube docker-env)
docker build -t spring-shop-backend .
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
minikube service spring-shop-backend-service
minikube ip
http://<minikube-ip>:8080
kubectl get deployments
kubectl get pods
kubectl get svc
kubectl delete -f deployment.yaml
```