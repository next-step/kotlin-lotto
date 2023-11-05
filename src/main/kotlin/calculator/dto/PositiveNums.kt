package calculator.dto

data class PositiveNums(val positiveNums: List<PositiveNum>) {
    fun sum(): Int {
        return positiveNums.sumOf { it.value.toInt() }
    }
}
