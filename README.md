# OpenMadiun
![alt tag](https://raw.githubusercontent.com/winnerawan/openmadiun/master/sss.png)
### Build with Spark Java & MongoDB
### Build Status 
[![Build Status](https://api.travis-ci.org/winnerawan/openmadiun.svg?branch=master)](https://travis-ci.org/winnerawan/openmadiun)         [![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)
## Aplikasi Madiun City Guide dengan banyak fitur
### Repository ini sebagai backend (REST API) tanpa database nya tentunya.
### List Fitur (11 Februari 2017)
  * Sign Up
  * Sign In
  * User Interaction
    * Social Network Concept
      * Follow
      * Unfollow
      * Posting
  * Kost
    * Penyedia jasa dapat mempromosikan tempatnya.
  * Doctor , masukkan penyakit dan dapatkan doctor yg cocok  
  * Homestay
  * Kodepos
  * Cuaca
  * Obyek Wisata
  * Coffee Shop
  * DLL
  * Sugesstion ? send an email!
  * Google Map v2 ? Google Place Api ? No Problem! will code later...
  
# License 
```html
/****************************************************************************
 Copyright 2016 Winnerawan T

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
****************************************************************************/
```
  
# Contoh 

## List Obyek Wisata
  * Request
    * _GET_ ```/place/tour```
  * Response
```js
{
  "status": 200,
  "message": "OK",
  "result": [
    {
      "id": "5899b3f6af9fb14829458448",
      "title": "Telaga Ngebel",
      "location": {
        "address": "Ponorogo Jawa Timur",
        "latitude": -7.7971918,
        "longitude": 111.6235559
      },
      "description": "telaga",
      "telephone": "",
      "category": "tour",
      "opening_hours": "00:00-00:00 WIB",
      "price_range": "10.000/people",
      "rating": 6.2,
      "img_url": "https://mw2.google.com/mw-panoramio/photos/medium/65434049.jpg"
    },
    {
      "id": "5899b487af9fb14829458449",
      "title": "Telaga Sarangan",
      "location": {
        "address": "Sarangan Plaosan Megetan Jawa Timur",
        "latitude": -7.677222,
        "longitude": 111.2155893
      },
      "description": "telaga",
      "telephone": "",
      "category": "tour",
      "opening_hours": "00:00-00:00 WIB",
      "price_range": "10.000/people",
      "rating": 8.9,
      "img_url": "http://www.yukpiknik.com/wp-content/uploads/2015/04/telaga-sarangan-3-1.jpg"
    },
    {
      "id": "589b903d666a6f1c9f02e3ba",
      "title": "Monumen Kresek",
      "location": {
        "address": "Kresek, Wungu, Madiun, Jawa Timur",
        "latitude": -7.7051069,
        "longitude": 111.6290412
      },
      "description": "monument",
      "telephone": "",
      "category": "tour",
      "opening_hours": "08:00 AM - 05:00 PM WIB",
      "price_range": "Free",
      "rating": 4.3,
      "img_url": "http://static.panoramio.com/photos/large/82777960.jpg"
    }
  ]
}
```
  
## Sign Up
  * Request
    * _POST_ ```/signup```
      * Paramater
          * username
          * email
          * password
          * user type (user/penyedia jasa)
  * Response
  
```js
{
  "status": 200,
  "message": "OK",
  "result": {
    "id": "589c41ed666a6f36fa204e79",
    "username": "winnerawan",
    "email": "winnerawan@gmail.com",
    "password": "$2a$12$Wya8Q2Rydc7CnIQREapVwuvUZQZrh4jvCFNeEwZzaJWq10sciS4VC",
    "type": {
      "type": "admin"
    }
  }
}
```
  * _Password Encoding using BCrypt_ 
  
## Find User
  * Request 
     * _GET_ ```/user/:username```
  * Response
```js
{
  "status": 200,
  "message": "OK",
  "result": {
    "id": "589c472a666a6f3709ca21f0",
    "username": "jannah",
    "email": "jannah@gmail.com",
    "password": "$2a$12$5AE.oSORbbszGsAOYMZ.Gus4465dHx.DSchZjj2eUq0nlwaKIvzCy",
    "type": {
      "type": "user"
    }
  }
}
```
  * Response 404 (Not Found)
  
```js
{
  "status": 404,
  "message": "Saya tahu Anda sedang mencari air, tapi maaf Bung, ini gurun!"
}
```

## Follow User
 * Sign In dulu
   * Request 
     * _POST_ ```/follow/:username```
   * Response 
```js
{
  "status": 200,
  "message": "OK",
  "result": {
    "follower_id": "589c41ed666a6f36fa204e79",
    "followee_id": "589c472a666a6f3709ca21f0"
  }
}
```  
  
    
### Anak IT ? Males ngerjain aplikasi skripsi ? 
### Menerima pembuatan aplikasi android (back-end & front-end)
### contact : winnerawan@gmail.com

#EOF  
  
  
  

  
