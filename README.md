# artistSong
RESTful API for songs and their details built using Spring Boot

## Running the application

- Setup a PostgreSQL database called song
- Run the app using Gradle
```
.\gradlew bootRun
```
- Requests
```
GET http://localhost:8080/api/v1/song

Response

[
  {
    "id": 1,
    "name": "Without Me",
    "artist": "Halsey",
    "album": "Manic",
    "release": "2018-10-04"
  },
  {
    "id": 2,
    "name": "No Right To Love You",
    "artist": "Rhys Lewis",
    "album": "Things I Chose To Remember",
    "release": "2020-05-18"
  }
]
```

```
POST http://localhost:8080/api/v1/song
Content-Type: application/json

{
    "name": "Ghost",
    "artist": "Halsey",
    "album": "Badlands",
    "release": "2014-07-28"
}
```

```
DELETE http://localhost:8080/api/v1/song/1
```

```
PUT http://localhost:8080/api/v1/song/1?album=Panic at the Disco!&release=2020-05-22
```