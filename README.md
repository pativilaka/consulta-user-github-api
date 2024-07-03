# Consulta Usuário GitHub

Este projeto é um exemplo simples de um programa em Java que consulta informações de um usuário no GitHub usando a API do GitHub. Ele utiliza a biblioteca Gson para parsear o JSON retornado pela API e exibe as informações do usuário no console.



O projeto utiliza a nova funcionalidade de `record` introduzida no Java 16 para representar os dados do usuário do GitHub. Um `record` é uma classe especial que simplifica a criação de classes que são principalmente usadas para transportar dados. 



![](https://github.com/pativilaka/consulta-user-github-api/blob/main/img/record.png)



No exemplo acima, `UserRecord` contém três campos: `login`, `id` e `url`. O método `toString` foi sobrescrito para fornecer uma formatação personalizada para a saída do console.



### Vantagens de usar `record`

- **Menos código boilerplate**: Um `record` automaticamente gera métodos como `equals`, `hashCode` e `toString`, além dos getters para os campos.
- **Imutabilidade**: Todos os campos de um `record` são finais, garantindo que os valores não possam ser alterados após a criação do objeto.



## Contato

[Linkedin ](https://www.linkedin.com/in/pativilaka/)