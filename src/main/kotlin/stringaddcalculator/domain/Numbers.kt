package stringaddcalculator.domain

class Numbers(private val numbers: List<Number>) {

    init {
        require(numbers.isNotEmpty()) { "숫자가 존재하지 않습니다." }
    }
    fun sum(): Int {
        return numbers.sumOf { it.value }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Numbers

        return numbers == other.numbers
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }
}
