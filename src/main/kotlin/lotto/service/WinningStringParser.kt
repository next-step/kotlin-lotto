package lotto.service

import lotto.model.WinningNumbers

object WinningStringParser {
    fun parse(input: String): WinningNumbers {
        val split = input.split(",")
        return WinningNumbers.of(split.map { it.toInt() })
    }
}
