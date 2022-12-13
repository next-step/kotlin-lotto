package lotto.service

object LottoStringParser {
    fun parse(input: String): List<Int> {
        return input.split(",").map { it.trim().toInt() }
    }
}
