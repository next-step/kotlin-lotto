package stringaddcalculator.domain

class Numbers(private val numbers: List<Number>) {

    init {
        require(numbers.isNotEmpty()) { "숫자가 존재하지 않습니다." }
    }
    fun sum(): Int {
        return numbers.sumOf { it.value }
    }
}
