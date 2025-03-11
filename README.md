# shedlock-example
POC utilizando ShedLock que é uma biblioteca Java 
integrada com o Spring para lock's distribuídos em tarefas agendadas. 
O ShedLock prevê vários recursos para gerenciar os lock's (https://github.com/lukas-krecan/ShedLock)

## Setup
Adicionando a depêndencia abaixo é possível adicionar o core do ShedLock.

```xml
<dependency>
    <groupId>net.javacrumbs.shedlock</groupId>
    <artifactId>shedlock-spring</artifactId>
    <version>6.3.0</version>
</dependency>
```

Na ```ShedLockConfig``` é possível definir qual o recurso que será utilizado 
para gerenciar o lock distribuído. No exemplo dessa POC escolhi o **Redis**.

Para isso foi necessário outra dependência exclusiva do ShedLock + Redis

```xml
<dependency>
   <groupId>net.javacrumbs.shedlock</groupId>
   <artifactId>shedlock-provider-redis-spring</artifactId>
   <version>6.3.0</version>
</dependency>
```

A anotação **@EnableSchedulerLock** deve ser adicionada em uma bean de configuração 
ou na classe que possui **@SpringBootApplication**. 
Essa Enable obriga o preenchimento do argumento ```defaultLockAtMostFor``` com a finalidade de evitar possíveis deadlock's.

A anotação **@SchedulerLock** deve ser adicionada com um ```name``` único 
nos métodos das tarefas agendadas com **@Scheduled**. 
O ```lockAtMostFor``` pode ser sobreescrito do valor default definido na @Enable, pois cada lock pode ter suas particularidades.

## Execução/teste
Executar duas instâncias da aplicação em portas diferentes (Ex: 8080 e 8081) e observar os log's.