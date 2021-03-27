package domain.lotto

import domain.statistics.WinningCategory

class Lottos(private val values: List<Lotto>) {
    val size: Int = values.size

    fun matches(winningNumbers: LottoNumbers): Map<WinningCategory, Int> {
        return values.map { lotto -> WinningCategory.matchNumberOf(lotto.countMatchedBy(winningNumbers)) }
            .groupingBy { it }
            .eachCount()
    }

    fun toList(): List<Lotto> = values
}
