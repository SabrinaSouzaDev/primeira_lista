# Projeto: Gerenciamento de Tarefas (Task Manager)

Este projeto é uma API RESTful desenvolvida em **Java com Spring Boot** para gerenciar tarefas. Ele permite a criação, leitura, atualização e exclusão (CRUD) de tarefas, utilizando um banco de dados em memória **H2** para armazenamento. A API segue as boas práticas de desenvolvimento e é documentada com o **Swagger** para facilitar o teste e a integração.

---

## Funcionalidades Principais

- **Criação de Tarefas**: Crie novas tarefas com título, descrição e status de conclusão.
- **Listagem de Tarefas**: Obtenha uma lista de todas as tarefas cadastradas.
- **Busca de Tarefa por ID**: Recupere os detalhes de uma tarefa específica pelo seu ID.
- **Atualização de Tarefas**: Atualize os detalhes de uma tarefa existente.
- **Exclusão de Tarefas**: Remova uma tarefa do sistema.

---

## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação principal.
- **Spring Boot**: Framework para desenvolvimento rápido de aplicações Java.
- **Spring Data JPA**: Camada de persistência para interação com o banco de dados.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
- **Swagger (springdoc-openapi)**: Documentação automática da API.
- **Maven**: Gerenciamento de dependências e build do projeto.
- **Extensões recomendadas no VS Code**:
Spring Boot Tools (para integração com o Spring Boot)
Java Extension Pack (inclui várias ferramentas úteis para Java, como o Language Support for Java)

---

## Como Executar o Projeto

Siga os passos abaixo para configurar e executar o projeto localmente.

### Pré-requisitos

- Java 21 instalado.
- Maven instalado.
- Git instalado (opcional, para clonar o repositório).

### Passos

1. **Clone o Repositório**:

```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   cd nome-do-repositorio
```

2. **Compile o Projeto**:

```bash
mvn clean package -DskipTests
```

#### 3. **Execute o Projeto**:

Se você está utilizando o VS Code para o desenvolvimento, siga esses passos para rodar o projeto com facilidade:

##### 1. Instale a Extensão Spring Boot Dashboard

   - Abra o VS Code.

   - Vá para a Visualização de Extensões (ícone de quadrado no lado esquerdo) ou use o atalho Ctrl + Shift + X.

   - Pesquise por Spring Boot Dashboard e clique em Instalar.

**Isso adicionará suporte para rodar e depurar facilmente sua aplicação Spring Boot no VS Code.**

##### 2. Abra o Projeto no VS Code

   - Certifique-se de ter aberto a pasta do projeto no VS Code.

##### 3. Rodando o Projeto

  Após a instalação da extensão Spring Boot Dashboard:

   - Clique na Visualização do Spring Boot Dashboard no lado esquerdo (ícone de quadrado com o logotipo do Spring).

   - Você verá sua aplicação listada. Clique em Run para iniciar a aplicação.

Alternativamente, você pode:

   - Usar o Start Debugging (F5).
   - Ou clicar com o botão direito na classe principal (PrimeiroApplication.java) no Explorer e escolher Run Java ou Debug Java.

#### 4️⃣ **Execute o Projeto no VS Code**:

Siga um desses passos para rodar o projeto com facilidade:

1. Com estes 2 scripts sh, vai ser feito o deploy e rodar o projeto. 
Execute o comando a baixo no terminal:

```bash
./deploy.sh && ./run.sh   
```

2. Instale a Extensão Spring Boot Dashboard

   - Abra o VS Code.

   - Vá para a Visualização de Extensões (ícone de quadrado no lado esquerdo) ou use o atalho Ctrl + Shift + X.

   - Pesquise por Spring Boot Dashboard e clique em Instalar.

**Isso adicionará suporte para rodar e depurar facilmente sua aplicação Spring Boot no VS Code.**

3. Abra o Projeto no VS Code

   - Certifique-se de ter aberto a pasta do projeto no VS Code.

4. Rodando o Projeto

  Após a instalação da extensão Spring Boot Dashboard:

   - Clique na Visualização do Spring Boot Dashboard no lado esquerdo (ícone de quadrado com o logotipo do Spring).

   - Você verá sua aplicação listada. Clique em Run para iniciar a aplicação.

Alternativamente, você pode:

   - Usar o Start Debugging (F5).
   - Ou clicar com o botão direito na classe principal (PrimeiroApplication.java) no Explorer e escolher Run Java ou Debug Java.

##### 5️⃣ **Acesse a API**:

Acesse o Swagger UI em http://localhost:8080/swagger-ui/index.html#/ para testar os endpoints.

<!-- 5. **Banco de Dados H2**:

O console do H2 pode ser acessado em http://localhost:8080/h2-console.

Use as credenciais configuradas no application.properties (usuário sa, senha password). -->


## Endpoints da API

A API oferece os seguintes endpoints:

| **Método HTTP** | **Endpoint**         | **Descrição**                               |
|------------------|----------------------|---------------------------------------------|
| GET              | /api/tasks          | Retorna todas as tarefas.                  |
| GET              | /api/tasks/{id}     | Retorna uma tarefa específica pelo ID.     |
| POST             | /api/tasks          | Cria uma nova tarefa.                      |
| PUT              | /api/tasks/{id}     | Atualiza uma tarefa existente.             |
| DELETE           | /api/tasks/{id}     | Exclui uma tarefa pelo ID.                 |

# Exemplos de Uso

## Criar uma Tarefa

### Requisição:

```bash
POST /api/tasks
Content-Type: application/json

{
  "title": "Estudar Spring Boot",
  "description": "Aprender a criar APIs RESTful com Spring Boot.",
  "completed": false
}
```

### Resposta:

```bash
{
  "id": 1,
  "title": "Estudar Spring Boot",
  "description": "Aprender a criar APIs RESTful com Spring Boot.",
  "completed": false
}
```
### Listar Tarefas
### Requisição:

```bash
GET /api/tasks
```
### Resposta:

```bash
[
  {
    "id": 1,
    "title": "Estudar Spring Boot",
    "description": "Aprender a criar APIs RESTful com Spring Boot.",
    "completed": false
  }
]
```
### Atualizar uma Tarefa
### Requisição:

```bash
Copy
PUT /api/tasks/1
Content-Type: application/json

{
  "title": "Estudar Spring Boot e JPA",
  "description": "Aprender a criar APIs RESTful e usar JPA com Spring Boot.",
  "completed": true
}
```
### Resposta:

```bash
{
  "id": 1,
  "title": "Estudar Spring Boot e JPA",
  "description": "Aprender a criar APIs RESTful e usar JPA com Spring Boot.",
  "completed": true
}
```

# Estrutura do Projeto
```bash
PRIMEIRA_LISTA/
├── .mvn/
├── .vscode/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── primeira_lista/
│   │   │           └── primeiro/
│   │   │               ├── controller/
│   │   │               │   └── TaskController.java
│   │   │               ├── model/
│   │   │               │   └── Task.java
│   │   │               ├── repository/
│   │   │               │   └── TaskRepository.java
│   │   │               ├── service/
│   │   │               │   ├── TaskService.java
│   │   │               │   └── TaskServiceImpl.java
│   │   │               └── PrimeiroApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── primeira_lista/
│                   └── primeiro/
│                       └── PrimeiroApplicationTests.java
├── target/
├── .gitattributes
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

# Configurações do Projeto
#### application.properties
**properties**

```bash
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Enable H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# OpenAPI/Swagger Configuration
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.api-docs.path=/api-docs

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.4</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.primeira_lista</groupId>
    <artifactId>primeiro</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>primeiro</name>
    <description>Demo project for Spring Boot</description>
    
    <properties>
        <java.version>21</java.version>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.8.5</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

# Como Contribuir

1. **Faça um fork do repositório**.

2. **Crie um branch para sua feature**:  
```bash
   git checkout -b feature/nova-feature
```
3. **Faça commit das suas alterações**:
```bash
   git commit -m 'Adiciona nova feature'
```
4. **Envie o branch para o repositório remoto**:
```bash
git push origin feature/nova-feature
```
5. **Abra um pull request**.
    Com tudo organizado e confira se todos os arquivos foram enviados corretamente.