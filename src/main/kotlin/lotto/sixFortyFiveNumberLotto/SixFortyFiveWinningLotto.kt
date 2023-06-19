package lotto.sixFortyFiveNumberLotto

import lotto.ErrorCode

class SixFortyFiveWinningLotto(
    private val lotto: SixFortyFiveLotto,
    val bonusNumber: SixFortyFiveNumber? = null,
) {

    init {
        bonusNumber?.let {
            val isDuplicated = lotto.numbers.find { number -> number.value == bonusNumber.value } != null
            if (isDuplicated) throw RuntimeException(ErrorCode.INVALID_SIX_FORTY_FIVE_BONUS_LOTTO_NUMBER.msg)
        }
    }

    fun getNumbers(): SixFortyFiveLotto {
        if (bonusNumber == null) return lotto
        val numberListWithBonus = listOf(*lotto.numbers.toTypedArray(), bonusNumber!!)
        return SixFortyFiveLotto(numberListWithBonus)
    }

    fun getWinningResultEnumList(
        lottoList: List<SixFortyFiveLotto>,
    ): List<SixFortyFiveWinningEnum> {
        return lottoList.map { lotto ->
            SixFortyFiveWinningEnum.valueOf(lotto.checkWinning(this))
        }
    }

    fun convertWinningResultEnumListToMap(winningResultEnumList: List<SixFortyFiveWinningEnum>): MutableMap<SixFortyFiveWinningEnum, Int> {
        val lottoWinningEnumPairs = SixFortyFiveWinningEnum.values().map { it to 0 }.toTypedArray()
        val winningResultEnumMap = mutableMapOf(*lottoWinningEnumPairs)
        winningResultEnumList.map { winningResultEnum ->
            winningResultEnumMap[winningResultEnum] = winningResultEnumMap[winningResultEnum]!!.plus(1)
        }
        return winningResultEnumMap
    }

    fun getEarningRate(winningResultList: List<SixFortyFiveWinningEnum>, lottoCount: Int): Double {
        val totalResultPrice = winningResultList.map { it.price }.reduce { acc, count -> acc + count }
        val totalPurchasePrice = lottoCount * SixFortyFiveLotto.LOTTO_PRICE
        return totalResultPrice / totalPurchasePrice.toDouble()
    }
}
