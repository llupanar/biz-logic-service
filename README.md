# biz-logic-service

## Зависисмости

### spring-boot-starter-data-jpa

Предоставляет необходимые компоненты для работы с JPA, которая упрощает реализацию слоя доступа к данным, а также обеспечивает интеграцию с Hibernate.

### spring-boot-starter-web

Добавляет необходимые компоненты для создания веб-приложений.

### postgresql

Предоставляет драйвер JDBC для PostgreSQL.

### hibernate-core

Предоставляет основную функциональность фреймворка Hibernate ORM, который упрощает сопоставление Java-объектов с таблицами БД.

## Запуск проекта

1. Скачать проект
2. Ввести в `src/resources/application.properties` данные от БД
3. Запустить сервер 

## Коллекции запросов

### Position

1. Создание 

```
HTTP method: POST
URL: /api/v1/position
```
Request body:
```
{
  "name": "Manager",
  "salary": 50000,
  "status": "A"
}
```
2. Обновление 

```
HTTP method: PUT
URL: /api/v1/position
```
Request body:
```
{
  "name": "Trainee",
  "salary": 50,
  "status": "N"
}
```

3. Удаление

```
HTTP method: DELETE
URL: /api/v1/position/{id}
```
4. Просмотр

```
HTTP method: GET
URL: /api/v1/position
```

5. Просмотр конкретного

```
HTTP method: GET
URL: /api/v1/position/{id}
```

### Employee

1. Создание

```
HTTP method: POST
URL: /api/v1/employee
```
Request body:
```
{
  "fullName": "John Doe",
  "birthDate": "1990-05-15",
  "gender": "M",
  "positionId": 1
}
```
2. Обновление

```
HTTP method: PUT
URL: /api/v1/employee/{id}
```
Request body:
```
{
  "fullName": "John",
  "birthDate": "1990-12-15",
  "gender": "F",
  "positionId": 1
}
```

3. Удаление

```
HTTP method: DELETE
URL: /api/v1/employee/{id}
```
4. Просмотр

```
HTTP method: GET
URL: /api/v1/employee
```

5. Просмотр конкретного

```
HTTP method: GET
URL: /api/v1/employee/{id}
```