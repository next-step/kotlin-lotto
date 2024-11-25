package additioncalculator.domain

data class Numbers(val numbers: List<Int>) {
    fun sum(): Int {
        if (numbers.isEmpty()) return DEFAULT_SUM_VALUE
        return numbers.sum()
    }

    companion object {
        const val DEFAULT_SUM_VALUE: Int = 0
    }
}