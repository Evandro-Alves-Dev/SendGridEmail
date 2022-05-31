# SendGridEmail
Projeto para envio de email através do SendGrid

## Passos para rodar o projeto localmente
1 - Depois de clonar o projeto será necessario criar um cadastro na pataforma sendgrid (https://sendgrid.com/marketing/sendgrid-services-pt/), tutorial para cadastro no site (https://www.youtube.com/watch?v=06M3lZzZEMY)
2 - No arquivo application.properties colocar a variavel de ambiente onde esta guardado a chave gerada pelo sendgrid ou colocar a chave direto no arquivo
3 - Rodar o projeto e utilizar o postman para fazer a chamada.

curl --location --request POST 'http://localhost:8080/emails' \
--header 'Content-Type: application/json' \
--data-raw '{
    "fromEmail": "teste@teste.com.br",
    "fromName": "João Demetrio",
    "replyTo": "teste@teste.com.br",
    "to": "destinatario@destinatario.com.br",
    "subjetc": "Meu assunto",
    "body": "Meu conteudo do email <stong>palavra forte</strong> destacada.",
    "contentType": "text/html"
}'
