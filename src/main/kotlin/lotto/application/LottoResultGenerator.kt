package lotto.application

import lotto.domain.LottoNumbers
import lotto.domain.LottoNumbersList
import lotto.domain.LottoRank
import lotto.domain.LottoResult
import lotto.domain.WinningNumbers
import java.util.EnumMap

data class LottoResultGenerator(private val winningNumbers: WinningNumbers, private val lottoNumbersList: LottoNumbersList) {
    fun getResult(): LottoResult {
        val lottoResult: EnumMap<LottoRank, Int> = initLottoResult()
        lottoNumbersList.value.forEach {
            val lottoNumbers = LottoNumbers(it.value)
            val lottoRank = winningNumbers.getLottoRank(lottoNumbers)
            lottoResult[lottoRank] = lottoResult.getOrDefault(lottoRank, DEFAULT_COUNT) + INCREASE_COUNT
        }
        return LottoResult(lottoResult)
    }

    private fun initLottoResult(): EnumMap<LottoRank, Int> {
        val lottoResult: EnumMap<LottoRank, Int> = EnumMap(LottoRank::class.java)
        LottoRank.values().forEach {
            lottoResult[it] = DEFAULT_COUNT
        }
        return lottoResult
    }

    companion object {
        private const val DEFAULT_COUNT = 0
        private const val INCREASE_COUNT = 1
    }
}
