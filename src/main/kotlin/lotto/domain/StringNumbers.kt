package lotto.domain

class StringNumbers(numberStrings: String) {
    val numbers: List<String>

    init {
        numbers = numberStrings.split(",")
        require(numbers.isNotEmpty() && numbers.size == Lotto.LOTTO_NUMBERS_COUNT) { "input string delimiter" }
    }
}
