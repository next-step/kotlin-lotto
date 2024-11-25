package additioncalculator.domain

data class Numbers(val numbers: List<Int>) {
    fun sum(): Int {
        if (numbers.isEmpty()) return 0
        return numbers.sum()
    }
}