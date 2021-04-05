package domain.lotto

import domain.winning.WinningCategory
import domain.winning.WinningNumbers

class Lottos(private val values: List<Lotto>) {
    val size: Int = values.size

    operator fun plus(other: Lottos): Lottos {
        return Lottos(values + other.values)
    }

    fun matches(winningNumbers: WinningNumbers): Map<WinningCategory, Int> {
        return values.map { lotto -> winningNumbers.determineWinning(lotto) }
            .groupingBy { it }
            .eachCount()
    }

    fun toList(): List<Lotto> = values
}
