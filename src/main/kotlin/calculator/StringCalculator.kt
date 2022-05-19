package calculator

class StringCalculator {

    fun add(input: String?): Int {
        return if (input.isNullOrBlank()) return 0 else input.toInt()
    }
}
