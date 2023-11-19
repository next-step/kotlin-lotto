package lotto.domain

import java.util.EnumMap

class LottoResultMap(
    private val lottoResultMap: EnumMap<LottoResult, Int>,
) {
    init {
        for (lottoResult in LottoResult.values()) {
            lottoResultMap[lottoResult] = lottoResultMap[lottoResult] ?: 0
        }
    }

    fun getLottoResultMapFilteredNotNone(): Map<LottoResult, Int> {
        return lottoResultMap.filter { it.key != LottoResult.NONE }
    }

    fun getLottoResultCount(lottoResult: LottoResult): Int {
        return lottoResultMap[lottoResult] ?: 0
    }

    fun getTotalCount(): Int {
        return lottoResultMap.values.sum()
    }

    fun getWinningPrice(): Double {
        return lottoResultMap.map { it.key.price * it.value }.sum().toDouble()
    }

    companion object {
        fun of(result: List<LottoResult>): LottoResultMap {
            val lottoResultMap = EnumMap<LottoResult, Int>(LottoResult::class.java)
            result.forEach { lottoResultMap[it] = lottoResultMap[it]?.plus(1) ?: 1 }
            return LottoResultMap(lottoResultMap)
        }
    }
}
