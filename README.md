# Projeto: Gerenciamento de Tarefas (Task Manager)

Este projeto é uma API RESTful desenvolvida em **Java com Spring Boot** para gerenciar tarefas. Ele permite a criação, leitura, atualização e exclusão (CRUD) de tarefas, utilizando um banco de dados em memória **Postgres** para armazenamento. A API segue as boas práticas de desenvolvimento e é documentada com o **Swagger** para facilitar o teste e a integração.

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
- **PostgreSQL**: Banco de dados utilizado para persistir as tarefas.
- **Swagger (springdoc-openapi)**: Documentação automática da API.
- **Maven**: Gerenciamento de dependências e build do projeto.

---

## Como Executar o Projeto

Siga os passos abaixo para configurar e executar o projeto localmente.
Siga os passos abaixo para configurar e executar o projeto localmente.

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
```

#### 1️⃣ 📌 Pré-requisitos
Antes de iniciar, certifique-se de que possui os seguintes softwares instalados:

- ✅ Java 21 Verifique com o comando java -version.
- ✅ Maven (mvn -v para verificar)
- ✅ PostgreSQL (psql --version para verifica)
- ✅ Visual Studio Code (VS Code)
- ✅ Extensões recomendadas no VS Code:
Spring Boot Tools (para integração com o Spring Boot)
Java Extension Pack (inclui várias ferramentas úteis para Java, como o Language Support for Java)

### Passos

#### 🗄 2️⃣ Configurar o Banco de Dados PostgreSQL
1. Inicie o PostgreSQL no seu sistema.

2. Crie o banco de dados para a API:

```bash
CREATE DATABASE meu_banco;
```
3. Crie um usuário e conceda permissões:

```bash
CREATE USER meu_usuario WITH PASSWORD 'minha_senha';
ALTER DATABASE meu_banco OWNER TO meu_usuario;
GRANT ALL PRIVILEGES ON DATABASE meu_banco TO meu_usuario;
```
4. Atualize as configurações no application.properties ou application.yml do seu projeto:

```bash

spring.datasource.driver-class-name: org.postgresql.Driver
spring.datasource.url: jdbc:postgresql://${POSTGRES_HOST}:${POSTGRES_PORT}/${POSTGRES_DB}
spring.datasource.username: ${POSTGRES_USER}
spring.datasource.password: ${POSTGRES_PASSWORD}

spring.jpa.database: postgresql
spring.jpa.properties.hibernate.dialect: org.hibernate.dialect.PostgreSQLDialect 
spring.jpa.show-sql: true

```
#### 🔄 🐘 5. Verifique se o PostgreSQL está rodando

```bash
pg_isready -h localhost -p 5432 -U meu_usuario
```
#### 6. Se der erro, inicie o PostgreSQL:
```bash
sudo systemctl stop postgresql
sudo systemctl start postgresql  # Linux
```
  6.1. Verifique se a porta está em uso: Utilize o comando abaixo para identificar se a porta 5432 está sendo utilizada por outro processo. Ou altere as configurações da sua aplicação para utilizar uma porta diferente, caso a porta 5432 já esteja em uso por outro serviço.

```bash
sudo lsof -i :5432
sudo kill -9 <PID> # Substitua <PID> pelo número do ID do processo identificado.
```

🗑 6.2. Exclua target/ e recompilar
```bash
rm -rf target
./mvnw clean package -DskipTests
```

#### 🔧 3️⃣ Compilar o Projeto

```bash
mvn clean package -DskipTests
```

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

Acesse o Swagger UI em http://localhost:9000/swagger-ui/index.html#/ para testar os endpoints.


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
### Listar Todas as Tarefas
## Requisição:

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
│   ├── launch.json
│   └── settings.json
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── primeira_lista/
│   │   │           └── primeiro/
│   │   │               ├── config/
│   │   │               │   ├── properties/
│   │   │               │   │   └── SecurityProperties.java
│   │   │               │   └── security/
│   │   │               │       ├── CorsProperties.javaCorsProperties.java
│   │   │               │       └── SecurityConfig.java 
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
├── .env
├── .env.example
├── .gitattributes
├── .gitignore
├── deploy.sh
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── run.sh
```

# Configurações do Projeto
#### application.properties
**properties**

```bash
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
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
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
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			 <scope>runtime</scope>
		</dependency>
		 <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
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