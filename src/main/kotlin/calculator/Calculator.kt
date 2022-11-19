package calculator

class Calculator {
    fun calculate(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val numbers = PositiveNumbers.parse(
            Separates.parse(text)
                .toIntList()
        )

        return numbers.sum()
    }
}
