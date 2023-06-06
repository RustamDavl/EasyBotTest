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
| get    | /api/v1/[typeOfGoods]/{id} | find one product by type and id |
| post   | /api/v1/[typeOfGoods] | create product with specified type     |
| patch  | /api/v1/[typeOfGoods]/{id} | edit the product by id         |
| get    | /api/v1/[typeOfGoods] | find all goods by type       |





**4. Example of data for request** \br

Each of product has it's own `additional field` :
- formfactor(for computer)
- size (for laptop)
- volume (for hdd)
- diagonal (for monitor)

each of additional field can have values shown below:
```
Goods:
  computer:
    formfactor: 
     - настольный пк
     - нет-топ
     - моноблок
  laptop:
    size:
    - 13 дюймов
    - 14 дюймов
    - 15 дюймов
    - 17 дюймов  
  hdd:
   volume:
    - 256 МБ
    - 512 МБ
    - 1 ТБ
    - 2 ТБ
  monitor:
   diagonal:
    - 21 дюйм
    - 24 дюймa
    - 27 дюймов
    - 32 дюйма
```
Example of request for laptop product
```
{
    "series" : "series",
    "producer" : "producer",
    "price" : "1234",
    "amount" : "12",
    "size" : "15 дюймов"
}
```