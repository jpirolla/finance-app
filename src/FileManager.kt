import java.io.File

class FileManager(
    private val incomeFileName: String,
    private val budgetsFileName: String,
    private val expensesFileName: String
) {
    // Métodos para ganho mensal
    fun readIncome(): Income? {
        val file = File(incomeFileName)
        return if (file.exists() && file.readText().isNotBlank()) {
            val amount = file.readText().toDoubleOrNull()
            amount?.let { Income(it) }
        } else {
            null
        }
    }

    fun writeIncome(income: Income) {
        val file = File(incomeFileName)
        file.writeText(income.amount.toString())
    }

    // Métodos para orçamentos de categoria
    fun readBudgets(): List<CategoryBudget> {
        val budgets = mutableListOf<CategoryBudget>()
        val file = File(budgetsFileName)

        if (file.exists()) {
            file.forEachLine { line ->
                val parts = line.split(",")
                if (parts.size == 2) {
                    val budget = CategoryBudget(parts[0], parts[1].toDouble())
                    budgets.add(budget)
                }
            }
        }
        return budgets
    }

    fun writeBudgets(budgets: List<CategoryBudget>) {
        val file = File(budgetsFileName)
        file.printWriter().use { out ->
            budgets.forEach { budget ->
                out.println("${budget.category},${budget.amount}")
            }
        }
    }

    // Métodos para despesas
    fun readExpenses(): List<Expense> {
        val expenses = mutableListOf<Expense>()
        val file = File(expensesFileName)

        if (file.exists()) {
            file.forEachLine { line ->
                val parts = line.split(",")
                if (parts.size == 3) {
                    val expense = Expense(parts[0], parts[1], parts[2].toDouble())
                    expenses.add(expense)
                }
            }
        }
        return expenses
    }

    fun writeExpenses(expenses: List<Expense>) {
        val file = File(expensesFileName)
        file.printWriter().use { out ->
            expenses.forEach { expense ->
                out.println("${expense.description},${expense.category},${expense.amount}")
            }
        }
    }
}
