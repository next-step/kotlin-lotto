package domain.lotto

import domain.winning.WinningCategory

class Lottos(private val values: List<Lotto>) {
    val size: Int = values.size

    fun matches(winningNumbers: LottoNumbers): Map<WinningCategory, Int> {
        return values.mapNotNull { lotto -> WinningCategory.matchNumberOf(lotto.countMatchedBy(winningNumbers)) }
            .groupingBy { it }
            .eachCount()
    }

    fun toList(): List<Lotto> = values
}
