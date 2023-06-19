package lotto.sixFortyFiveNumberLotto

import lotto.ErrorCode

class SixFortyFiveLottoWinningNumber(_value: List<SixFortyFiveNumber>) : SixFortyFiveLottoNumber(_value) {
    override val value: List<SixFortyFiveNumber>
        get() {
            if (bonusNumber == null) return super.value
            return listOf(*super.value.toTypedArray(), bonusNumber!!)
        }
    var bonusNumber: SixFortyFiveNumber? = null
        set(value) {
            if (value == null) return
            val isDuplicated = super.value.find { number -> number.value == value.value } != null
            if (isDuplicated) throw RuntimeException(ErrorCode.INVALID_SIX_FORTY_FIVE_BONUS_LOTTO_NUMBER.msg)
            field = value
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
