# Análise comparativa de algoritmos de ordenação aplicado a dados da COVID-19

### Grupo : José Carlos Souza de Oliveira, Lucas Henrique Guerra Pereira / UEPB 2021
<br>

### 1- Objetivos do Projeto
 
O primeiro projeto da disciplina de Estrutura de Dados visa utilizar os dados da COVID-19 do Brasil.IO para estudarmos o desempenho dos algoritmos de ordenação.
A partir de um arquivo dataset no formato csv a aplicação irá organizar os dados baseados em quantidade acumulada de óbitos, quantidade acumulada de casos e por ordem alfabética pelo nome das cidades.
 
### 2- Desenvolvimento

A aplicação foi desenvolvida usando java e tem a "Application.java"como classe de aplicação, além das classes auxiliares "OrdenacaoComparativa.java","OrdenacaoLinear.java","OrdenacaoRecursao.java" e "GerarCsv.java" localizadas na pasta raiz do projeto.
 
### 3- Guia de execução
 
3.1 Para a execução da aplicação é necessário ter a JDK (Java Development Kit) instalada no computador.
 
3.2 Baixe o dataSet neste [link](https://brasil.io/dataset/covid19/caso_full/?search=&epidemiological_week=&date=&order_for_place=&state=&city=&city_ibge_code=&place_type=&last_available_date=&is_last=True&is_repeated=False) de forma que as opções de filtro "É a última atualização?" seja True e "Dado repedito?" seja False.

3.3 Após baixar o arquivo csv o mesmo deve ser copiado para a pasta covid-data e deve ser renomeado para "covid-data".

3.4 Através do terminal execute a classe principal "Application.java" que está na pasta raiz do projeto, dessa forma o programa executará todas as outras classes automaticamente, indicando os métodos de ordenação executados seguidos do tempo e gerando os arquivos csv na pasta resultados.

3.5 Comandos para utilizar no terminal:

1-`  javac Application.java`

2-`  java Application`