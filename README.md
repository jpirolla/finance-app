# Aplicativo de Controle Financeiro em Kotlin
![Status](https://img.shields.io/badge/status-em%20andamento-yellow)

Este é um aplicativo simples de controle financeiro desenvolvido em Kotlin. Ele permite que você gerencie seu ganho mensal, defina orçamentos para diferentes categorias e registre suas despesas. O aplicativo armazena todos os dados em arquivos de texto.

## Funcionalidades

- Inserir ganho mensal.
- Definir orçamentos para diferentes categorias.
- Adicionar despesas com descrição e categoria.
- Visualizar despesas registradas e o orçamento restante para cada categoria.

## Estrutura do Projeto

O projeto é composto pelos seguintes arquivos Kotlin:

- `Income.kt`: Define a classe `Income` para representar o ganho mensal.
- `CategoryBudget.kt`: Define a classe `CategoryBudget` para representar o orçamento por categoria.
- `Expense.kt`: Define a classe `Expense` para representar uma despesa com descrição, categoria e valor.
- `FileManager.kt`: Implementa a classe `FileManager` para ler e escrever dados relacionados ao ganho mensal, orçamentos de categoria e despesas.
- `Main.kt`: Implementa a função principal (`main`) que gerencia a interação com o usuário, permitindo inserção de dados, adição de despesas e visualização dos orçamentos restantes.

## Pré-requisitos

- Kotlin 1.3 ou superior
- Java JDK 8 ou superior

## Instalação

### No Ubuntu

1. **Instale o JDK**:

    ```sh
    sudo apt update
    sudo apt install default-jdk
    ```

2. **Verifique a instalação do JDK**:

    ```sh
    java -version
    ```

    O comando acima deve exibir a versão do Java instalada.

3. **Baixe e instale o Kotlin**:

    ```sh
    sudo snap install --classic kotlin
    ```

4. **Verifique a instalação do Kotlin**:

    ```sh
    kotlinc -version
    ```

    O comando acima deve exibir a versão do Kotlin instalada.

## Compilação e Execução

1. **Clone o repositório** (ou crie o diretório e adicione os arquivos manualmente):

    ```sh
    git clone <URL_DO_SEU_REPOSITORIO>
    cd <NOME_DO_REPOSITORIO>
    ```

2. **Compile os arquivos Kotlin**:

    ```sh
    kotlinc src/*.kt -include-runtime -d FinancialControl.jar
    ```

    Este comando compila todos os arquivos Kotlin na pasta `src` e cria um arquivo JAR chamado `FinancialControl.jar`.

3. **Execute o programa**:

    ```sh
    java -jar FinancialControl.jar
    ```

## Uso

Ao executar o programa, você verá um menu interativo com as seguintes opções:

1. **Inserir ganho mensal**:
    - Permite que você insira seu ganho mensal.

2. **Inserir orçamento para categoria**:
    - Permite que você defina um orçamento para uma categoria específica.

3. **Adicionar despesa**:
    - Permite que você adicione uma nova despesa com descrição, categoria e valor.

4. **Ver despesas e orçamentos restantes**:
    - Exibe todas as despesas registradas e o orçamento restante para cada categoria.

5. **Sair**:
    - Encerra o programa.

## Exemplo de Uso

1. **Inserir ganho mensal**:
    - Digite o valor do seu ganho mensal quando solicitado.

2. **Inserir orçamento para categoria**:
    - Digite o nome da categoria e o valor do orçamento para essa categoria.

3. **Adicionar despesa**:
    - Digite a descrição, categoria e valor da despesa.

4. **Ver despesas e orçamentos restantes**:
    - Exibe uma lista de todas as despesas e o valor restante para cada categoria.


