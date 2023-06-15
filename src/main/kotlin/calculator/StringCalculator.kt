package calculator

class StringCalculator {

    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) return 0

        val parsedInput = input.toIntOrNull()
        if (parsedInput == null || parsedInput < 0) {
            throw RuntimeException()
        }

        return 1
    }
}
