package domain.lotto

import domain.winning.WinningCategory
import domain.winning.WinningNumbers

class Lottos(private val values: List<Lotto>) {
    val size: Int = values.size

    fun matches(winningNumbers: WinningNumbers): Map<WinningCategory, Int> {
        return values.map { lotto -> winningNumbers.determineWinning(lotto) }
            .groupingBy { it }
            .eachCount()
    }

    fun toList(): List<Lotto> = values
}
