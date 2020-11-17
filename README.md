# Song Lyrics App - server
API for last.fm and genius.com

### Requirements
* JDK 1.8 or later

### Getting started

#### Step 1: Clone this Repository
`git clone git@github.com:SLA-PPSM/server.git`

#### Step 2: Build and run with Maven Wrapper
`./mvnw spring-boot:run`

### Endpoints

#### Currently playing song
```
GET http://localhost:8080/api/lastfm/getRecentTracks/{nick}

Response
{
    "artist": "BonSoul",
    "title": "Małpi gaj",
    "image": "https://lastfm.freetls.fastly.net/i/u/34s/148c616d5ced6f7ec1c2520c87e10142.jpg",
    "date": "now"
}
```

#### Recent tracks
```
GET http://localhost:8080/api/lastfm/getRecentTracks/{nick}

Response
[
    {
        "artist": "WHITE 2115",
        "title": "Kap Kap",
        "image": "https://lastfm.freetls.fastly.net/i/u/34s/3d0c7d27272d26f112f45baf6fa01dbf.jpg",
        "date": "1605572809"
    },
    {
        "artist": "WHITE 2115",
        "title": "Morgan",
        "image": "https://lastfm.freetls.fastly.net/i/u/34s/3d0c7d27272d26f112f45baf6fa01dbf.jpg",
        "date": "1605572615"
    },
    {...}
]
```

#### Profile
```
GET http://localhost:8080/api/lastfm/getProfile/{nick}

Response
{
    "nick": "freakinlikemj",
    "avatar": "https://lastfm.freetls.fastly.net/i/u/34s/23d26647c064ea1f7124490360d5a0e4.png",
    "scrobbles": "82963"
}
```

#### Friends
```
GET http://localhost:8080/api/lastfm/getFriends/{nick}

Response
[
    {
        "nick": "kkornel99",
        "avatar": "https://lastfm.freetls.fastly.net/i/u/34s/8005a609a98f67d86a4ffb81a260c3ab.png"
    },
    {
        "nick": "szymcio10",
        "avatar": "https://lastfm.freetls.fastly.net/i/u/34s/2d1857ab6694b8c28971ff56566d81f4.png"
    },
    {...}
]
```