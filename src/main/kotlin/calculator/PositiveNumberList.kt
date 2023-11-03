package calculator

data class PositiveNumberList(val tokenList: List<PositiveNumber>) {
    val sum: Int = tokenList.sumOf { it.number }
}
