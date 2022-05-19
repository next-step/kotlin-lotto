package calculator

class StringCalculator {

    fun add(input: String?): Int {
        return if (input.isNullOrBlank()) {
            0
        } else {
            val token = input.split(",").map { it.toInt() }
            when (token.size) {
                2 -> token[0] + token[1]
                else -> token[0]
            }
        }
    }
}
