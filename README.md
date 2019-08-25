# SpringCode
Iniciar o server ProvaAplication.java
Testar as chamadas de Api:
Api para postar um texto

POST  http://localhost:8080/api/textos
  Body ->
  {
  "texto": "funciona"
  }
  
  
Api para obter todos os posts
GET http://localhost:8080/api/textos

Api para postar um upvote
POST http://localhost:8080/api/textos/{id_post}/upvote/

A interface não esta finalizada, mas retorna os posts criados, esta na pasta client, é preciso executar npm start
