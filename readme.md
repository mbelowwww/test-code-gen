Пример генерации клиента на основе Open-API 3.0.
OkHttp 4.2.0./moshi

Как использовать:
1) Загрузить в openapi/spec.yaml актуальную версию спецификации API
2) Очищаем старый билд
```
./gradlew clean
```
2) Выполнить команду 2 раза (Не вызывая clean)! С 1 раза может не сработать.
```
./gradlew generateApiJar
```
3) Готовый .jar файл лежит в папке build
