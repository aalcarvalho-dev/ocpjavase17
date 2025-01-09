# ocpjavase17
## Capítulo 1

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