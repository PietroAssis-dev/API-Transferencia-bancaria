# Projeto Bancário

Aplicação desenvolvida em Spring Boot para simular operações bancárias, como criação de contas e transferências de valores entre contas.

## 2. Tecnologias
- Java 25
- Spring Boot 4.0.3
- Spring Data JPA
- PostgreSQL (ou H2 para testes)
- Maven

## 3. Como rodar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/projeto-bancario.git

2. Configure o banco de dados no application.properties:
   ```bash
   
   spring.datasource.url=jdbc:postgresql://localhost:5432/projeto_bancario
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
3. Compile e rode
   ```bash
   mvn spring-boot:run
4. A aplicação estara disponivel em:
   ```bash
   http://localhost:8080

  
---

### 4. Endpoints disponíveis

### Endpoints

### Criar conta
`POST /bancario/conta`

Body (JSON):
```bash
{
  "nome": "Pietro Assis",
  "cpf": "12345678900",
  "email": "pietro@email.com",
  "valorBancario": 1000
}

```
Listar contas:
GET /bancario/contas


Resposta recebida:
```bash
  {
    "id": 1,
    "nome": "Pietro Assis",
    "cpf": "12345678900",
    "email": "pietro@email.com",
    "valorBancario": 800.0
  }

```

### Transferencia de valor
```
{
  "idOrigem": 1,
  "idDestino": 2,
  "valor": 200
}

resposta: Transferência realizada com sucesso

---

```

### Historico de Transferencia: 
```
localhost:8080/bancario/historico/1

coloque isso caso ja tenha feito uma transferencia

```
### 5. Próximos passos
## Próximos passos

- Adicionar autenticação com Spring Security
- Criar testes unitários e de integração





   
