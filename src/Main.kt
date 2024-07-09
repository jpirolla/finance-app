fun main() {
    val fileManager = FileManager("income.txt", "budgets.txt", "expenses.txt")
    var running = true

    while (running) {
        println("\nControle Financeiro")
        println("1. Inserir ganho mensal")
        println("2. Inserir orçamento para categoria")
        println("3. Adicionar despesa")
        println("4. Ver despesas e orçamentos restantes")
        println("5. Sair")
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
                println("Digite a categoria para definir o orçamento:")
                val category = readLine().orEmpty()
                println("Digite o valor do orçamento para essa categoria:")
                val amount = readLine()?.toDoubleOrNull() ?: 0.0
                val budget = CategoryBudget(category, amount)
                val budgets = fileManager.readBudgets().toMutableList()
                budgets.add(budget)
                fileManager.writeBudgets(budgets)
                println("Orçamento para categoria $category definido!")
            }
            3 -> {
                println("Descrição da despesa:")
                val description = readLine().orEmpty()
                println("Categoria da despesa:")
                val category = readLine().orEmpty()
                println("Valor da despesa:")
                val amount = readLine()?.toDoubleOrNull() ?: 0.0
                val expense = Expense(description, category, amount)
                val expenses = fileManager.readExpenses().toMutableList()
                expenses.add(expense)
                fileManager.writeExpenses(expenses)
                println("Despesa adicionada!")
            }
            4 -> {
                val expenses = fileManager.readExpenses()
                val budgets = fileManager.readBudgets()

                if (expenses.isEmpty()) {
                    println("Nenhuma despesa encontrada.")
                } else {
                    println("\nLista de Despesas:")
                    expenses.forEach { println(it) }
                }

                println("\nOrçamentos Restantes:")
                budgets.forEach { budget ->
                    val totalSpent = expenses.filter { it.category == budget.category }.sumOf { it.amount }
                    val remainingBudget = budget.amount - totalSpent
                    println("Categoria: ${budget.category}, Orçamento Restante: R$%.2f".format(remainingBudget))
                }
            }
            5 -> running = false
            else -> println("Opção inválida.")
        }
    }
}
