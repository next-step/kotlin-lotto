package lotto.domain

import lotto.model.Lotto
import java.math.BigDecimal

class LottoResultStore(
    private val winningLotto: Lotto,
    lottoList: List<Lotto>,
) {
    private val resultMap = mutableMapOf(
        LottoWinPlace.FIRST to 0,
        LottoWinPlace.SECOND to 0,
        LottoWinPlace.THIRD to 0,
        LottoWinPlace.FOURTH to 0,
    )

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

    companion object {
        private const val MIN_WINNING_COUNT = 3
    }
}

@JvmInline
value class LottoResult(val lottoResultMap: Map<LottoWinPlace, Int>) {
    fun getSum(): Int = lottoResultMap.values.sum()
}

enum class LottoWinPlace(val prizeMoney: BigDecimal, val matchingNumberCount: Int) {
    FOURTH(BigDecimal(5000), 3),
    THIRD(BigDecimal(50000), 4),
    SECOND(BigDecimal(1_500_000), 5),
    FIRST(BigDecimal(2_000_000_000), 6),
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
