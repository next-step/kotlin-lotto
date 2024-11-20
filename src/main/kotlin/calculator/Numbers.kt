package calculator

class Numbers(private val values: List<Number>) {
    val sum: Int = values.sumOf { it.value }
}
