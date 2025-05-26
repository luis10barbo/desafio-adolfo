## Desafio Técnico - Desenvolvimento de Aplicação Web Full Stack

###
Acesse o desafio em https://desafio.luisbrb.com.br/

### Objetivo
Desenvolver uma aplicação web fullstack que permita gerenciar e consultar **Órgãos Institucionais**, **Áreas Temáticas** e **Notícias**, de acordo com os requisitos funcionais e técnicos descritos abaixo.

---

### Funcionalidades

- Modelagem e implementação de uma base de dados relacional com as entidades:
  - **Órgão Institucional**
  - **Área Temática**
  - **Notícia** (pertence a um Órgão e a uma Área Temática)

- Implementação de 3 endpoints REST:
  - Obter a lista de Órgãos
  - Obter a lista de Áreas Temáticas
  - Obter a lista paginada de Notícias

- Criação de uma interface web conforme o protótipo fornecido:
  - Exibição de notícias com filtros por Órgão e Área Temática
  - Botão "Pesquisar" que atualiza os resultados
  - Paginação vertical com botão **"Ver Mais"** para carregar as próximas 8 notícias

---

### Requisitos Técnicos

#### Backend
- Linguagem: **Java 17**
- Framework: **Spring Boot**
- Banco de Dados: **MySQL** ou **PostgreSQL**
- Acesso aos dados via **JdbcTemplate**

#### Frontend
- Framework: **Angular 14**
- Componentização:
  - Criação de um componente reutilizável para exibir notícias
- Estilo:
  - **PrimeNG**, **SCSS (CSS PURO com algumas váriaveis)**

---

### Observações
- As entidades **Órgão** e **Área Temática** são independentes.
- A seção de notícias é dinâmica, aplicando filtros e paginando os resultados conforme interação do usuário.

## Estrutura do projeto Angular
```
app
├── 📁 model # Modelos TypeScript que representam as entidades de dados
├── 📁 noticia # Componente responsável pela exibição das notícias na interface
├── 📁 service # Serviços responsáveis pela comunicação com a API
│ ├── 📁 area-tematica # Serviço para operações relacionadas às Áreas Temáticas
│ ├── 📁 noticias # Serviço para operações relacionadas às Notícias
│ └── 📁 orgao-institucional # Serviço para operações relacionadas aos Órgãos Institucionais
├── app-routing.module.ts # Configuração das rotas da aplicação
├── app.component.* # Arquivos do componente raiz da aplicação
└── app.module.ts # Módulo principal que declara e importa os componentes e serviços
```

## Estrutura do projeto Spring
```
spring
├── 📁 config # Arquivos de configuração do projeto (CORS, segurança, etc.)
├── 📁 controller # Camada de controle (REST), responsável pelos endpoints da API
├── 📁 model # Modelos de dados da aplicação
│ ├── 📁 interfaces # Interfaces auxiliares para consultas ou abstrações
│ └── 📁 tabelas # Entidades que representam as tabelas do banco de dados
├── 📁 repository # Camada de acesso a dados (repositórios)
│ └── 📁 utils # Classes auxiliares para testes ou operações de suporte no repositório
└── DesafioApplication.java # Classe principal que inicia a aplicação Spring Boot
```
