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