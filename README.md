# PROJETO ESCOLA SEGURA 

CONTROLE DE ACESSO A ESCOLAS


> API Rest criado com funcionalidades básicas e essenciais (MVP) para
> o controle de acesso de alunos, funcionarios e visitantes nas Escolas
> Projeto criado com Java e SPRING BOOT.

> Vou apresentar a Entidade Aluno como forma de exemplo que se aplica ás demais partes do projeto.

> Classe Aluno representa uma tabela no banco de dados e é usada para armazenar informações sobre os alunos. 


## Tecnologias

Dependências: 
> Certifique-se de ter as seguintes dependências em seu projeto: 

- Spring Web.

- Spring Security.

- Spring DevTools (Facilita na atualização conforme alterações são feitas).

- Lombok (Diminui a quantidade de Boiler Plates).

- JPA (Java Persistence API).

- Banco de Dados (Neste caso utilizei o postgresql)

- Spring boot Validation (Utilizado para fazer validações)

## Técnicas

_A api foi separada em arquivos e pastas que facilitam a leitura, reutilização e teste de cada componente:_


- **EscolaSeguraApiApplication.java:** arquivo que faz a conexão e execução da a aplicação;
- **application.properties:** Reune as configurações de JPA, Hibernate e conexão com Banco de Dados;
- **WebConfig.java:** Arquivo foi criado para gerenciar as autorizações CrossOrigin do sistema;


 As pastas (packages) foram divididas em grupos e facilitam a visualização de cada parte do projeto conforme segue abaixo:

- **connection:** contém o arquivo que faz a conexão com o banco de dados;

- **controller:** possui os arquivos com as regras de negócios de cada entidade.

- **model:** possui os arquivos que criam as entidades no banco de dados, atribuem tipos e algumas validações;

- **repository:** Cada repository é uma interface que estende a classe JpaRepository com metodos já pré definidos, porém pode-se adicionar métodos personalizados conforme a necessidade;

## Testando a API

Abra a sua IDE e importe os arquivos para sua pasta: (Utilize o git clone para utilizar o código).


\*caso necessário, acesse a documentação disponibilizada para cada tecnologia utilizada no projeto e faça a sua instalação manualmente.
.
Verifique o arquivo pom.xml.O projeto deve conter todas as dependencias citadas acima.

## Rotas e funcionalidades

### **Cadastrar Aluno**

Esta rota tem por função cadastrar um novo aluno no banco de dados e retorna o id, e todos os demais dados referentes ao cadastro. (A funcionalidade fica dentro de AlunoController no Package controller.

```@PostMapping("/alunos")					//Using Method HTTP Post
	@ResponseStatus (HttpStatus.CREATED)
	public Aluno addAluno(@RequestBody @Valid Aluno aluno) {  //@RequestBody convert Json to Aluno type
		return alunoRepository.save(aluno);
	}
```

Os objetos que serão recebidos na requisição têm os seguintes atributos:

- **nomeCompleto**(string, obrigatório): O nome completo do aluno
- **cpf** (string, único e Válido): O CPF do aluno.
- **matricula** (Long, única): Matricula única de cada aluno.
- **telefone** (string): Número de telefone do aluno.
- **turna** (string): Turma de cada aluno.
- **foto** (string): Ainda não aplicável no modelo MVP.


O cpf é um dado único e obrigatório, para garantir sua exclusividade, existe a verificação se é válido.

Abaixo temos o Exemplo da Classe Aluno:

```
@Entity 						
@Table(name="aluno")
//@Data 									
@AllArgsConstructor 			       
@NoArgsConstructor	
public class Aluno {
	
	@Id 								
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	@Column                             
	Long id;
	
	@Column (nullable=false, length=100) 
	@NotBlank
	private String nomeCompleto;
	
	@Column (unique=true)
	@CPF
	private String cpf;
	
	@Column (unique=true, length=10)
	private Long matricula;
	
	@Column (nullable=false, length=14)
	private String telefone;
	
	@Column (length=10)
	private String turma;
```

Explicação das Anotações:

@Entity: Essa anotação serve para indicar representa uma tabela no banco de dados escolhido.

@Table(name="aluno"): Define o nome da tabela associada à entidade.

@Id: Indica a chave primária da tabela.

@GeneratedValue(strategy = GenerationType.IDENTITY): Especifica que a chave primária é gerada automaticamente usando uma coluna de identidade.

@Column: Indica que o campo está mapeado para uma coluna na tabela. (Não é mais necessário utiliza-la)

@NotBlank: Especifica que o campo não deve estar em branco ou nulo.

@CPF: Valida se o campo anotado representa um número de CPF válido. (Caso não seja válido o sistema envia um Erro)

@ManyToOne: Estabelece um relacionamento muitos-para-um entre entidades na tabela.

@JoinColumn(name = "responsavelId"): Especifica a coluna de chave estrangeira usada para unir a entidade Responsavel com a entidade Aluno.



### **Buscar pela Matricula - Aluno**


Esta rota tem por função buscar um aluno pela sua matrícula.

Foi necessário a criação de um método personalizado na Interface AlunoRepository no package repository.


```
@GetMapping("/alunos/matricula/{matricula}")
	public Aluno getAlunosByMatricula(@PathVariable Long matricula){
		return alunoRepository.findByMatricula(matricula);
	}

```

### **Buscar todos Alunos - Aluno**


Esta rota tem por função buscar todos os alunos cadastrados no Banco de Dados.

Foi utilizado um método já existente no JPA para a busca desses dados na Interface AlunoRepository no package repository.


```
@GetMapping("/alunos")   					
	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}

```



### **Remover Aluno - Aluno**


Esta rota tem por função remover um aluno específico pelo seu Id no Banco de Dados.

Foi utilizado um método já existente no JPA na Interface AlunoRepository no package repository.


```
@DeleteMapping("/alunos/{id}")
	public void removeAluno(@PathVariable Long id){
		alunoRepository.deleteById(id);
	}

```


### **Atualizar Aluno - Aluno**


Esta rota tem por função alterar um ou mais atributos de um aluno específico, sendo o mesmo buscado pela sua matrícula no Banco de Dados.

Foi utilizado um método personalizado na Interface AlunoRepository no package repository para a busca pela matricula.

```
@PutMapping("/alunos/{matricula}")
	public Aluno updateAluno(@PathVariable Long matricula,@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}

```

## Melhorias

- Fazer o tratamento de Erro de cada requisição;
- Definir se um aluno terá mais de um responsável atrelados a sua entidade;
- Melhorar a segurança do sistema com uso de Token;
- Fazer melhor uso do Spring-Security para segurança do sistema;
- Definir como implementar "foto" nas entidades; 


## Meus Contatos:

<div>
<a href="https://www.instagram.com/petronisrody/" target="_blank"><img src="https://img.shields.io/badge/-Instagram-%23E4405F?style=for-the-badge&logo=instagram&logoColor=white" target="_blank"></a>
<a href = "mailto:rodrigopetronis@hotmail.com"><img src="https://img.shields.io/badge/Hotmail-0078D4?style=for-the-badge&logo=windows-live-hotmail&logoColor=white" target="_blank"></a>
<a href="https://www.linkedin.com/in/rodrigo-petronis/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>   
</div>
