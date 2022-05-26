package calculator

fun Numbers(strings: List<String>) = Numbers(strings.map(String::toInt))

class Numbers(private val numbers: List<Int>) {
    val sum by lazy { numbers.sum() }

    init {
        checkIsNotNegative(numbers)
    }

    private fun checkIsNotNegative(numbers: List<Int>) {
        require(numbers.none { it < 0 }) { "음수값은 허용하지 않습니다." }
    }
}
