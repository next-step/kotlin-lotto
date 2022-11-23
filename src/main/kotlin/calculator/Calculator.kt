package calculator

class Calculator {
    fun calculate(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        return Separators.parse(text)
            .toPositiveNumbers()
            .sum()
    }
}
