fun main() {
    val fileManager = FileManager("income.txt", "expenses.txt")
    var running = true

    while (running) {
        println("Controle Financeiro")
        println("1. Inserir ganho mensal")
        println("2. Adicionar despesa")
        println("3. Ver despesas")
        println("4. Sair")
        println("Escolha uma opção:")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("Digite seu ganho mensal:")
                val amount = readLine()?.toDoubleOrNull()
                if (amount != null) {
                    fileManager.writeIncome(Income(amount))
                    println("Ganho mensal registrado!")
                } else {
                    println("Valor inválido.")
                }
            }
            2 -> {
                println("Descrição da despesa:")
                val description = readLine().orEmpty()
                println("Categoria da despesa:")
                val category = readLine().orEmpty()
                println("Valor da despesa:")
                val amount = readLine()?.toDoubleOrNull() ?: 0.0
                val expense = Expense(description, category, amount)
                fileManager.addExpense(expense)
                println("Despesa adicionada!")
            }
            3 -> {
                val expenses = fileManager.readExpenses()
                if (expenses.isEmpty()) {
                    println("Nenhuma despesa encontrada.")
                } else {
                    expenses.forEach { println(it) }
                }
            }
            4 -> running = false
            else -> println("Opção inválida.")
        }
    }
}
