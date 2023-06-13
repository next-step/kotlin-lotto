package domain

data class Expression(private val terms: List<Term>) {
    fun getSum(): Int = terms.sumOf { it.value }
}
