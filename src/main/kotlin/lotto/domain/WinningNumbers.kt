package lotto.domain

data class WinningNumbers(
    val numbers: Set<Int>,
    val bonusBall: Int,
) : Set<Int> by numbers
