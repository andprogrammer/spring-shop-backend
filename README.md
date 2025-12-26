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
    docker build -t spring-boot-app .
    ```

    ```bash
    docker run -d -p 8080:8080 --name spring-boot-container spring-boot-app
    ```

    http://localhost:8080

    ```bash
    docker stop spring-boot-container
    ```

    ```bash
    docker rm spring-boot-container
    ```

## Kubernetes
```bash
minikube start
eval $(minikube -p minikube docker-env)
docker build -t spring-boot-app .
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
minikube service spring-boot-app-service
minikube ip
http://<minikube-ip>:8080
kubectl get deployments
kubectl get pods
kubectl get svc
kubectl delete -f deployment.yaml
```