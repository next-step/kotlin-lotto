package stringadder.domain

class Parser {
    fun getOperands(input: String): List<Int> {
        return input.split(",", ":").map { token -> token.toInt() }
    }
}