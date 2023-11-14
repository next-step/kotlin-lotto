package calculator.vo

data class PositiveNums(val positiveNums: List<PositiveNum>) {
    fun sum(): PositiveNum {
        return PositiveNum(positiveNums.sumOf { it.value })
    }

    fun size(): Int {
        return positiveNums.size
    }
}
