package lotto.domain

import lotto.model.Lotto
import java.math.BigDecimal

class LottoResultManager(
    private val winningLotto: Lotto,
    private val lottoList: List<Lotto>,
) {
    private val resultMap = mutableMapOf<LottoWinPlace, Int>()

    init {
        require(lottoList.isNotEmpty())
        require(winningLotto.value.isNotEmpty())

        lottoList.forEach {
            val count = it.value.count { number -> winningLotto.value.contains(number) }
            if (count >= MIN_WINNING_COUNT) {
                val place = LottoWinPlace.fromCount(count)
                val value = resultMap.getOrPut(place) { 0 }
                resultMap[place] = value + 1
            }
        }
    }

    fun getResult(): LottoResult {
        return LottoResult(resultMap)
    }

    fun getWinningRate(): Double {
        val totalLottoSize = lottoList.size.toDouble()
        val totalWin = resultMap.values.sumOf { it }.toDouble()
        return totalWin / totalLottoSize
    }

    companion object {
        private const val MIN_WINNING_COUNT = 3
    }
}

@JvmInline
value class LottoResult(val lottoResultMap: Map<LottoWinPlace, Int>)

enum class LottoWinPlace(val prizeMoney: BigDecimal, val matchingNumberCount: Int) {
    FIRST(BigDecimal(5000), 3),
    SECOND(BigDecimal(50000), 4),
    THIRD(BigDecimal(1_500_000), 5),
    FOURTH(BigDecimal(2_000_000_000), 6),
    ;

    companion object {
        fun fromCount(count: Int): LottoWinPlace {
            return entries.find { count == it.matchingNumberCount }
                ?: throw IllegalArgumentException("Invalid count $count")
        }

        fun getPlacesFromLowest(): List<LottoWinPlace> =
            listOf(
                FOURTH,
                THIRD,
                SECOND,
                FIRST,
            )
    }
}
