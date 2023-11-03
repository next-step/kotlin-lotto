package calculator

class Calculator {
    fun calculate(text: String?): Int {
        if (text.isNullOrEmpty()) return ZERO
        return Parser.parse(text).sum
    }

    companion object {
        const val ZERO = 0
    }
}
