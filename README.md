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
GET http://localhost:8080/api/lastfm/getCurrentTrack/{nick}

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

#### Search
```
GET http://localhost:8080/api/genius/search/{query}

Response
[
    {
        "id": 2827371,
        "artist": "Taco Hemingway",
        "title": "WOSK"
    },
    {
        "id": 5526965,
        "artist": "TACONAFIDE",
        "title": "#Hot16Challenge2"
    },
    {...}
]
```

#### Lyrics
```
GET http://localhost:8080/api/genius/getLyrics/{id}

Response
{
    "id": 2827371,
    "lyrics": "[Zwrotka 1]\nZnów pioruny oraz deszcze na Żoli\nDworzec Gdański ciągle tęskni za Bowiem\nPłyt słuchałem zamiast stawiać się na lekcje na Woli\nSłaby uczeń, ale po dekadzie jestem na swoim\nZeszło EPek ponad dziesięć patoli\nMiędzy nami spoko, weszło drugie miejsce na OLiS\nMam ambicje, powodzenia jak mi zechcesz zabronić\nW trakcie picia rosną pragnienia, jam się ledwie napoił\nPanie Romanie, niech pan leje napoje\nBo już minęły czasy grania za te sześćset na dwoje\nPiękna nuda mnie pochłania, tak jak w „Rejsie\" nastroje\nPora zacząć cumowanie, bo na mieście mam projekt\nMam dwadzieścia sześć lat i się czuję staro\nJuż nie palę, bo mnie zawsze płuca kłują rano\nJest już północ, także usiądź zostań u mnie na noc\nBiodra kręcą się jak czarny wosk i przejmują salon\n\n[Refren]\nBiodra kręcą się jak wosk i przejmują salon\nBiodra kręcą się jak wosk, biodra kręcą się jak...\n...wosk, wosk, wosk, wosk\nBiodra kręcą się jak wosk i przejmują salon\nBiodra kręcą się jak...\n\n[Zwrotka 2]\nJestem głosem pokolenia, które nie ma nic do powiedzenia\nMimo to relacjonuje wszystko, wszystkie posiedzenia\nKażde wyjście, kino, szybkie piwo, jeszcze szybszą miłość\nZa tą szybką zbitą krążą oczy jak po osi ziemia (Whoa)\nRozkosz dla wątroby i dla podniebienia (Whoa)\nCiężko staram się, by robić wszystko od niechcenia (Whoa)\nGdy ktoś stara się, to go wyzywam od jelenia\nZ jednej strony ciągle jestem wszędzie\nZ drugiej wciąż mnie nie ma\nAgrykola. Młody fan woła do mnie „Siema\"\nZdarza się to pierwszy raz odkąd chodzę biegać\nWe wzruszeniu zgarniam grzywę, bo chce fotę siekać\nPyta kiedy płyta, sklejam pionę, mówię: „Proszę czekać\"\nKorzystając z tej okazji podziękuję fanom\nTo dla Was siedzę nocą i modyfikuję kanon\nPióro gania po notesie, wykonuje slalom\nSłowa kręcą się jak wosk i przejmują salon\n\n[Refren]\nSłowa kręcą się jak wosk i przejmują salon\nSłowa kręcą się jak wosk, słowa kręcą się jak...\n...wosk, wosk, wosk, wosk\nSłowa kręcą się jak wosk i przejmują salon\nSłowa kręcą się jak...\n\n[Zwrotka 3]\nKiedyś skromne publiczności, teraz dosyć liczne\nSto koncertów, ale nie chcę dzisiaj o nich myśleć\nTrzeźwa głowa, ale słowa wiecznie oniryczne\nKtoś wywołał mnie bym pisał teksty polityczne?\nNie, dziękuję. Wolę pisać o sobie\nWolę pisać o ludziach, wolę pisać o Tobie\nGdy odejdą wszyscy fani, wtedy znikam, dosłownie\nNa krótką chwilę. Potem wracam, żeby pisać ponownie\nPracoholik, nieustannie się stresuję labą (Whoa)\nAtakują mnie koszmary, ja je szczuję jawą (Whoa)\nStudio na dziewiątą rano, znowu pluję kawą (Whoa)\nChryste, Rumak, co to jest za bit, chyba czuję zawał\nNie pytasz jak nam idzie, wiesz że tu nutę nagrano\nCzekasz już w domu, ale wiesz że ja wrócę tam rano\nNazajutrz wracam, nie chcesz gadać, chcesz muzykę samą\nBiodra kręcą się jak czarny wosk i przejmują salon\n\n[Refren]\nBiodra kręcą się jak wosk i przejmują salon\nBiodra kręcą się jak, biodra kręcą się jak...\n...wosk, wosk, wosk, wosk\nBiodra kręcą się jak wosk i przejmują salon\n(Wosk, wosk, wosk, wosk, wosk....)\nBiodra kręcą się jak wosk...\n(Wosk, wosk, wosk, wosk, wosk....)\n\nTekst - Rap Genius Polska"
}
```
