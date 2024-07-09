data class Expense(val description: String, val category: String, val amount: Double) {
    override fun toString(): String {
        return "Descrição: $description, Categoria: $category, Valor: R$%.2f".format(amount)
    }
}
