import java.io.File

// Classe FileManager responsável por ler e escrever ganhos e despesas em arquivos TXT
class FileManager(private val incomeFileName: String, private val expenseFileName: String) {

    // Lê o ganho mensal do arquivo incomeFileName
    fun readIncome(): Income? {
        val file = File(incomeFileName)
        return if (file.exists() && file.readText().isNotBlank()) {
            val amount = file.readText().toDoubleOrNull()
            amount?.let { Income(it) }
        } else {
            null
        }
    }

    // Escreve o ganho mensal no arquivo incomeFileName
    fun writeIncome(income: Income) {
        val file = File(incomeFileName)
        file.writeText(income.amount.toString())
    }

    // Lê as despesas do arquivo expenseFileName
    fun readExpenses(): List<Expense> {
        val expenses = mutableListOf<Expense>()
        val file = File(expenseFileName)

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

    // Escreve as despesas no arquivo expenseFileName
    fun writeExpenses(expenses: List<Expense>) {
        val file = File(expenseFileName)
        file.printWriter().use { out ->
            expenses.forEach { expense ->
                out.println("${expense.description},${expense.category},${expense.amount}")
            }
        }
    }

    // Adiciona uma nova despesa ao arquivo expenseFileName
    fun addExpense(expense: Expense) {
        val expenses = readExpenses().toMutableList()
        expenses.add(expense)
        writeExpenses(expenses)
    }
}
