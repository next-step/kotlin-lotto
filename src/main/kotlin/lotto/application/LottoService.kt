package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoNumberGenerator
import lotto.domain.Rank

class LottoService(
    val lottos: List<Lotto>,
) {
    fun matchWinningNumber(winningNumbers: List<Int>): Map<Rank, Int> {
        val matchResult = mutableMapOf<Rank, Int>()
        lottos
            .map { it.matchWinningNumber(winningNumbers) }
            .map { Rank.valueOf(it) }
            .forEach { matchResult[it] = matchResult.getOrDefault(it, 0) + 1 }
        return matchResult.toMap()
    }

    companion object {
        fun generateAutoLotto(lottoCount: Int = 1): LottoService {
            val lottos: List<Lotto> = (0 until lottoCount)
                .map { LottoNumberGenerator.generate() }
                .map { Lotto(it) }
                .toList()

            return LottoService(lottos)
        }
    }
}
