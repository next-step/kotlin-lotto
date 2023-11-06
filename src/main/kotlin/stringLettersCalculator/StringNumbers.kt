package stringLettersCalculator

class StringNumbers(
    private val stringNumbers: List<StringNumber> = listOf()
) {

    fun numbersToInt(): List<Int> = stringNumbers.map {
        it.toInt()
    }

    fun sumNumbers(): Int = stringNumbers.map { it.toInt() }
        .sumOf { it }

    companion object {
        fun from(numberStrings: List<String>) = StringNumbers(
            List(numberStrings.size) {
                StringNumber(numberStrings[it])
            }
        )
    }
}
