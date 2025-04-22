## 🔍 Query By Example (QBE) com Spring Data JPA

**Query By Example (QBE)** permite criar consultas dinâmicas e simples no Spring Data JPA sem escrever SQL ou JPQL.

### 🧪 Exemplo Básico
```java
Cliente example = new Cliente();
example.setNome("João");
example.setCidade("São Paulo");

Optional<Cliente> cliente = repo.findOne(Example.of(example));
```

🔧 Filtro com ExampleMatcher
```
ExampleMatcher matcher = ExampleMatcher.matchingAll()
    .withMatcher("nome", contains())
    .withMatcher("cidade", exact());

List<Cliente> clientes = repo.findAll(Example.of(example, matcher));

```

⚠️ Limitações
Não indicado para joins, subqueries ou agregações

Pode ter performance inferior em consultas complexas

✅ Ideal Para
Consultas simples, dinâmicas e com pouco código


