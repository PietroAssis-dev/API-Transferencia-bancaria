# Projeto Bancário

Aplicação desenvolvida em Spring Boot para simular operações bancárias, como criação de contas e transferências de valores entre contas.

## Tecnologias
- Java 25
- Spring Boot 4.0.3
- Spring Data JPA
- PostgreSQL (ou H2 para testes)
- Maven

## Como rodar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/projeto-bancario.git
   spring.datasource.url=jdbc:postgresql://localhost:5432/projeto_bancario
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update

   mvn spring-boot:run

   http://localhost:8080

  
---

### 4. Endpoints disponíveis
```markdown
## 📡 Endpoints

### Criar conta
`POST /bancario/conta`

Body (JSON):
```json
{
  "nome": "Pietro Assis",
  "cpf": "12345678900",
  "email": "pietro@email.com",
  "valorBancario": 1000
}

### Listar contas:
GET /bancario/contas
[
  {
    "id": 1,
    "nome": "Pietro Assis",
    "cpf": "12345678900",
    "email": "pietro@email.com",
    "valorBancario": 800.0
  }
]

### Transferencia de valor
http POST :8080/bancario/transferir idOrigem==1 idDestino==2 valor==200



---

### 5. Próximos passos
```markdown
## Próximos passos
- Implementar histórico de transações
- Adicionar autenticação com Spring Security
- Criar testes unitários e de integração





   
