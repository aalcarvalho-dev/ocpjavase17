# Capítulo 1
## Building Blocks

- Assinatura de método consiste do nome do método e o tipo do parâmetro:  
```numberVisitors(int)```

- Comentário multi-linha é definido apenas pelos itens:  
```/* e \*```  
Os asteriscos intermediários de início de linha são opcionais!
- Modificadores **final** opcionais no método _main_:
> public **final** static void main(**final** String[] args){}
- Em um arquivo chamado Animal.java, incluí duas classes:  
```Dog{} e  Cat{}```  
O arquivo foi compilado normalmente. Em tempo de execução deu erro. Exigiu um método main declarado.  
O seguinte código compilou e rodou com ```javac Animal.java```:  
```
class Dog{public static void main(String... args){}}

class Cat{public static void main(String[] args){}}
```
- Se o arquivo possuir uma classe _public_, obrigatoriamente essa classe tem que ter o nome do arquivo. Ex.: ```class Dog``` para um arquivo ```Dog.java```
- Um arquivo deve possuir no máximo uma classe declarada como _public_
- Existem 3 declarações válidas para os parâmetros do método _main_:  
```String[] args```  
```String options[]```  
```String... friends```
- O import com wildcard (*) traz apenas as classes daquele pacote da hierarquia. Ex.:  
```import java.util.*```  
```import java.util.concurrent.*```  
A primeira importação não trará as classes do pacote filho, _concurrent_.  
A importação com wildcard não torna a aplicação lenta. O compilador verifica quais classes são necessárias realmente. Cabe a mim ou a equipe decidir como declarar os imports, uma vez que vários individuais, e não por pacotes, torna difícil a leitura.
- O pacote ***java.lang*** é um pacote especial. Ele é o único que é importado automaticamente. Ele pode ser declarado na lista de imports, mas é uma importação redundante. 
- Importar classes que estão no mesmo pacote da classe atual também é considerado redundante. Java procura automaticamente por classes no mesmo pacote.
- Um wildcard só verifica nomes de classes e não nomes de pacotes
- Só deve existir um wildcard por instrução import. Isso ```import java.nio.*.*``` não é possível.
- Nomes de classes iniciam com letra maiúscula, portanto um import do tipo ```import java.nio.file.Paths.*;``` não está correto, pois presume-se que ele busca por métodos dentro da classe Paths. *Só podemos importar nomes de classes*
- Um conflito de nome de classes pode ocorrer se eu necessito usar uma classe Date e tenho dois imports apontando para classes com esse nome. Ex.: ```import java.util.*``` e ```import java.sql.*``` causa erro de compilação.  
Mas se eu indicar claramente qual classe de qual pacote eu estou importando, isso toma precedência em relação a import com wildcards. Ex.: ```import java.util.Date``` e ```import java.sql.*``` poderiam coexistir e java.util.Date é considerada padrão. Nessa situação eu preciso de outras classes do pacote java.sql, que não a classe Date.  
Em uma situação de duas importação padrão, como ```import java.util.Date``` e ```import java.sql.Date``` apresenta erro, pois não podemos ter duas classes sugeridas como padrão. O compilador reclama de importação ambígua.  
Se eu realmente precisar usar duas classes com mesmo nome, porém de pacotes diferentes, as alternativas são escolher uma das duas pra ficar no import e a outra usar o FQN dela, ou remover os imports e usar o FQN para as duas. Ex.:
```
public class Conflicts{
    java.util.Date date;
    java.sql.Date sqlDate;
}
```
- Compilando e executando com pacotes. Para exemplificar, criar duas classes: ```ClassA``` e ```ClassB```. Criado o diretório cap1-ex1. Dentro dele, criado os diretórios _packagea_ e _packageb_. Em cada diretório foi incluído o respectivo arquivo de Classe.
Após isso, ir para o diretório raíz, o _cap1-ex1_. Executando o comando ```javac packagea/ClassA.java packageb.ClassB.java```. Por padrão, o javac compila o class para o mesmo diretório do fonte.
- Compilando para outro diretório. Utilizar a opção _-d <opção>_ para designar o diretório destino. Ao executar o comando ```javac -d classes packagea/ClassA.java packageb/ClassB.java```. A estrutura de pacotes é preservada dentro do diretório alvo, no caso _classes_.  
A estrutura criada seria:
```
-packagea
-- ClassA.java
-packageb
-- ClassB.java
- classes
--packagea
--- ClassA.class
--packageb
--- ClassB.class
```
Para rodar a aplicação, é necessário informar o classpath para o Java saber onde localizar as classes.
As 3 maneiras possíveis de execução são:
```
java -cp classes packageb.ClassB
java -classpath classes packageb.ClassB
java --class-path classes packageb.ClassB
```
- Criando um arquivo JAR. Utilizar o comando ```jar -cvf myNewFile.jar -C classes .``` o argumento depois do -C
é o diretório a ser agrupado e o "." indica onde salvar o arquivo .jar
- Criando Objetos. Ordem de inicialização:
1. Fields e Instance Initializer blocks na ordem em que aparecem
2. O Construtor executa depois que todos os fields e Instance Initializers blocks executam
- DataTypes. 8 primitivos (1by-2s-4i-8l-4flo-8do-boo-2char). Um primitivo é
um simples valor em memória, como um número ou caracter.  
Um float requer a letra f ou F acompanhando. Caso contrário, esse decimal é interpretado como um double.  
Um long requer um l ou L seguindo o número. Caso contrário, java interpreta esse número como um int.  
O tamanho de um boolean não é especificado e depende da jvm.  
Os tipos short e char são similares. 16 bits ambos. short é signed, ou seja, vai do negativo ao positivo.
já o char é exclusivamente positivo, até 65535 (conta o O). Eles podem sofrer cast entre si, sem problemas.  
Java assume que um número literal é um inteiro. Isso aqui não compila: ```long max = 325325325698```. Pra compilar,
necessário incluir um L ao lado do número. Sugestão é usar maiúsculo, pois o contrário pode
parecer o número 1.  
Sistemas de numeração em outras bases. Octal (0 - 7): o primeiro 0 é o prefixo. ex.: 017. Hexadecimal (0 -9 , A - F), prefixo 0x ou 0X. ex: 0xFF e é case insensitive.  
Binário (0 - 1), prefixo 0b ou 0B. ex.: 0b10, 0B10.  
Os literais podem ter underscore pra facilitar a leitura. ex.: ```int million = 1_000_000;```. Alguns exemplos:
```
double notAtStart = _1000.00; //não compila
double notAtEnd = 1000.00_; //não compila
double notByDecimal = 1000_.00; //não compila
double annoyingButLegal = 1_00_0.0_0; //ok, compila
double reallyUgly = 1_______2; // também compila
```
Tipos de referência. primitivos em minúsculo e referência em maiúsculo por convenção.  
Primitivos não podem ser associados a null. Referência, sim. ```int value = null //não compila```.  
Da mesma forma, primitivos não chamam métodos: ```int len = reference.length() //não compila```
- Criando Classes Wrapper. Segue alguns exemplos que compilam:
```
int num1 = 5;
int num2 = Integer.valueOf(6);
Integer num4;
int num5 = 2;
Integer num3 = 7;
num1 = num3;
num4 = num5;
System.out.println(num1);
System.out.println(num4);
int primitive = Integer.parseInt("123");
Integer wrapper = Integer.valueOf("123");
System.out.println(primitive);
System.out.println(wrapper);
Double apple = Double.valueOf(200.2);
System.out.println(apple.intValue());
System.out.println(apple.byteValue());
System.out.println(apple.shortValue());
System.out.println(apple.longValue());
System.out.println(apple.floatValue());
System.out.println(apple.doubleValue());
```
Definindo Text Blocks. Atribui a uma String o seguinte padrão: Após o sinal de atribuição, digita ```"""```. Quebra a linha e na sequência digita o texto. A partir do ponto mais a esquerda do texto, o espaçamento que for dado define o espaço em banco essencial. O fim do bloco é definido igualmente por ```"""```. Caso esse padrão esteja numa linha solo, e não ao final do texto, essa linha também é considerada. Exemplos:
```
String eyeTest = "\"Java Study Guide\"\n  by Scott & Jeanne";
System.out.println(eyeTest);
String textBlock = """
"Java Study Guide"
 by Scott & Jeanne""";
System.out.println(textBlock);
String pyramid = 
    """
      *
     *
    *
    """;
System.out.println(pyramid);
```
Na formatação do text block, temos algumas distinções em relação a String:
```
\"  "   "
\"""    n/a     """
\"\"\"  """     """
Space   Space   Ignored
\s      2 spcs  2 spcs
\ (end) n/a     Omits new line on that line
```
Declarando Variáveis. Regra:
```
- Comecaçam com letra, currency ou _.
- Identificador deve conter apenas letra, currency ou _
- Não começam com número, mas pode ter em outra posição
- Não pode usar uma palavra reservada do Java
- Não pode ter um _ simples como identificador
```
Declarando múltiplas variáveis. Regra:
```
- Posso declarar e inicializar múltiplas variáveis na mesma declaração
- As variáveis devem ser todas do mesmo tipo
- Uma declaração é definida por ;
- Um snippet é definido por ,
Ex.: String s1, s2;
String s3 = "yes", s4 = "no";
int i1, i2, i3 = 0; //3 declarações, 1 inicialização
int num, String value; //não compila
int num; String value; //ok
double d1, double d2; //não compila. duplicidade tipo
int i3; i4; //não compila. i4 não tem tipo.
```
Inicializando variáveis. Variáveis locais. Regra:
```
- variável local final não pode ser alterada
final int y = 10; int x = 20;
y = x + 10; //não compila
- Devemos inicializá-la antes do uso, pois não possuem valor padrão.
int y = 10; int x;
int reply = x + y; // não compila
```
Inferindo tipo com _var_. Regra:
```
- Usado apenas como variável local
Ex.: var name = "hello"; var size = 7;
- Se usado como variável de instância, não compila
Ex.: public class VarKeyword{
    var tricky = "Hello"; //não compila
}
- Náo é possível reassociar a um valor de outro tipo
Ex.: var number = 7; number = 4;
number = "five";//não compila
```
### Erros nas Review Questions
(2) Atenção ao marcar alternativas exclusivas. A questão pedia a ordem do PIC, porém as alternativas incluem declarações não obrigatórias, como P e I. Nesse caso, considera também as associações entre PC e IC e não somente o PIC.  
(5) A referência brownBear possui uma variável de instância pandaBear. Essa referência aponta para polarBear (B2), que foi criado na linha 10. Quando brownBear = null, a referência para polarBear é perdida, tornando o objeto elegível para GC.  
(7) Um text block é um bloco apenas de texto. Não há concatenação desse bloco com variáveis (usando o +nomeVariavel que usaríamos com uma String pura). Nesse caso, não podemos presumir que valores são 0 nas variáveis citadas. O texto é escrito literalmente.  
(8) Um var não pode inicializado como null, porém pode ser associado a um null se o tipo inferido não for um primitivo. ex.: ```var morning = ""; morning = null //ok```. Já ```var evening = 2; var = null //não compila ou var spring = null; //tb não```. A opção ```var day = 1/0``` funciona, pq a pergunta é se o código compila. Embora essa sentença
gere erro em tempo de execução, esse código compila. _var_ também não pode ser usada em uma associação multi-variável. Isso, não funciona: ```var fall = 2, autumn = 2;```  
(9) Uma variável de classe do tipo String (leia-se variável estática) tem seu default setado para null. Ex.: ```private static String nome;```
(12) Java não suporta setar valor padrão em parâmetro de método. Ex.: ```(int length=3)//não compila```  
(14) short não recebe um long. ```short numPets = 5L```. int não recebe um double. ```int numGrains = 2.0```.  
(15)  
(16)  
(18)  
(19)  
(20)  
(22)  
(23)