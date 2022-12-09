package lotto.service

object StringParser {
    fun parse(input: String): List<Int> {
        return input.split(",").map { it.trim().toInt() }
    }
}
