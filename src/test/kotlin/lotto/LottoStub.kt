package lotto

import lotto.domain.Lotto

object LottoStub {
    fun get(
        pickNumbers: List<Int> = (1..45).shuffled().take(6).sorted(),
        matchCount: Int = 0,
    ): Lotto {
        return Lotto.of(pickNumbers = pickNumbers).apply {
            updateMatchCount(matchCount)
        }
    }
}
