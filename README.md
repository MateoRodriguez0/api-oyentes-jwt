
# MusicApp(API OYENTES) 
Esta es una api que gestiona algunas peticiones para los oyentes de una app de musica.
Contribuye a la creacion de un proyecto spring boot con el proposito de implementar spring security jWT.


tiene como objetivo realizar las operaciones necesarias para los usuarios oyentes de la app en la base de datos.

## Datasource
``` java
spring.application.name=servicio-oyentes
server.port=8003

spring.datasource.url=jdbc:mysql://localhost:3306/appmusic?useSSL=false&serverTimezone=America/Bogota&AllowpublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

```



## Requeriments
- Java 17 o una version superior.
- MySQL 8



## Instalation

- Primero Descargamos la version mas actual del proyecto en el siguiente [enlace](https://github.com/MateoRodriguez0/appmusic-oyentes/releases/tag/version-1.0)
- luego, importamos la base de datos en nuestro gestor SGBD MySQL.
- importamos este proyecto en el IDE. 

luego de seguir los pasos anteriores solo faltaria ejecutar nuestro proyecto y probarlo.



## API Reference

#### Listar todas las favoritas

```http
  GET /listar/{id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `string` | **Required**. id del oyente que quiere ver sus canciones favoritas. |

#### Get favorita

```http
  GET /search/{idoyente}/{idfavorita}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idoyente`      | `string` | **Required**. Id del oyente|
| `idfavorita`      | `string` | **Required**. Id de la cancion en favoritas |


#### Agregar cancion a favoritas

```http
  POST /save/{idoyente}/{idcancion}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idoyente`      | `string` | **Required**. Id del oyente|
| `idfavorita`      | `string` | **Required**. Id de la cancion |





#### Elimina cancion a favoritas

```http
  DELETE /delete/{idoyente}/{idfavorita
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idoyente`      | `string` | **Required**. Id del oyente|
| `idfavorita`      | `string` | **Required**. Id de la cancion favorita, que será eliminada del listado|

# Examples 

```http
   localhost:8003/favoritas/listar/2
```

```Javascript
   [
    {
        "id": 4,
        "cancion": {
            "id": 5,
            "titulo": "Canción 5",
            "genero": "R&B",
            "duracion": "00:03:10",
            "estreno": "2023-10-07T03:57:14.000+00:00"
        },
        "agregada": "2023-10-07T01:43:59.000+00:00"
    }
]
```
