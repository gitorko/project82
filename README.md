# Project82

Spring Data JPA Essentials

### Version

Check version

```bash
$java --version
openjdk 17.0.3 2022-04-19 LTS
```

### Postgres DB

```
docker run -p 5432:5432 --name pg-container -e POSTGRES_PASSWORD=password -d postgres:14
docker ps
docker exec -it pg-container psql -U postgres -W postgres
CREATE USER test WITH PASSWORD 'test@123';
CREATE DATABASE "test-db" WITH OWNER "test" ENCODING UTF8 TEMPLATE template0;
grant all PRIVILEGES ON DATABASE "test-db" to test;

docker stop pg-container
docker start pg-container
```

There is a bug in spring data jpa where `jakarta.persistence.lock.timeout` is not working for postgres.
Hence set the timeout at database level to 10 seconds.

```bash
ALTER DATABASE "test-db" SET lock_timeout=10000;
```

To look at isolation level

```bash
SHOW default_transaction_isolation;
ALTER DATABASE "test-db" SET default_transaction_isolation = 'read committed'
```
