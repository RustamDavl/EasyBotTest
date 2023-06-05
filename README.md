# EasyBotTest


## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/RustamDavl/EasyBotTest.git
```

**2. Package the app**

```bash
mvn package
```
**3. Run the app**

```bash
mvn spring-boot:run
```


### Goods
there are 4 types of goods:
- computer
- hdd
- monitor
- laptop

| Method | URL                   | Description                  |
|--------|-----------------------|------------------------------|
| get    | /api/v1/[typeOfGoods]/{id} | find one type of goods by id |
| post   | /api/v1/[typeOfGoods] | create one type of goods     |
| patch  | /api/v1/[typeOfGoods]/{id} | edit the goods by id         |
| get    | /api/v1/[typeOfGoods] | find all goods by type       |
