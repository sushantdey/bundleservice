# bundleservice
Test/Sample repository for demo

### Dependencies

This service needs Redis and MYSQL services up and running

#### Sample `compose.yaml` for running Redis and MYSQL services:

```
services:
  redis:
    container_name: redis
    image: redis
    ports:
      - 6379:6379
    volumes:
      - /home/sushant/redis/redis.conf:/usr/local/etc/redis/redis.conf
      - /home/sushant/redis/data:/data
    network_mode: bundle_service_network
  mysql:
    container_name: mysql
    image: mysql
    ports:
      - 3306:3306
    environment:
      MYSQL_ROOT_PASSWORD: admin
      MYSQL_DATABASE: bundle_service
      MYSQL_USER: bundle_service
      MYSQL_PASSWORD: password
    volumes:
      - /home/sushant/mysql:/var/lib/mysql
    network_mode: bundle_service_network
```

### Build steps

#### Create docker image
```
DOCKER_BUILDKIT=1 docker build -t dt/bundle_service .
```
#### Run the docker container to bring up the service
```
docker compose up -d
```
#### Logs
```
docker logs bundle_service
```