package lotto.application

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.LottoRank
import lotto.domain.LottoResult
import lotto.domain.WinningNumbers
import java.util.EnumMap

data class LottoResultGenerator(private val winningNumbers: WinningNumbers, private val lottos: Lottos) {
    fun getResult(): LottoResult {
        val lottoResult: EnumMap<LottoRank, Int> = initLottoResult()
        lottos.value.forEach {
            val lotto = Lotto(it.value)
            val lottoRank = winningNumbers.getLottoRank(lotto)
            lottoResult[lottoRank] = lottoResult.getOrDefault(lottoRank, DEFAULT_COUNT) + INCREASE_COUNT
        }
        return LottoResult(lottoResult)
    }

    private fun initLottoResult(): EnumMap<LottoRank, Int> {
        return LottoRank.values()
            .associateWith { DEFAULT_COUNT }
            .toMap(EnumMap(LottoRank::class.java))
    }

    companion object {
        private const val DEFAULT_COUNT = 0
        private const val INCREASE_COUNT = 1
    }
}
