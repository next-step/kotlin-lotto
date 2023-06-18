package lotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoWinningNumber
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinning

object SixFortyFiveLottoUtils {
    fun parseNumbersFromStr(str: String, delimiter: Char): List<SixFortyFiveNumber> {
        return str.split(delimiter).map { SixFortyFiveNumber(it.toInt()) }
    }

    fun getWinningResultMap(): MutableMap<SixFortyFiveWinning, Int> {
        val lottoWinningEnumPairs = SixFortyFiveWinning.values().map { it to 0 }.toTypedArray()
        return mutableMapOf(*lottoWinningEnumPairs)
    }

    fun getWinningResultList(lottoList: List<SixFortyFiveLotto>, lottoWinningResultMap: MutableMap<SixFortyFiveWinning, Int>, winningValue: SixFortyFiveLottoWinningNumber): List<SixFortyFiveWinning> {
        return lottoList.map { lotto ->
            val result = SixFortyFiveWinning.valueOf(lotto.checkWinning(winningValue))
            lottoWinningResultMap[result] = lottoWinningResultMap[result]!!.plus(1)
            result
        }
    }

    fun getTotalResultPrice(winningResultList: List<SixFortyFiveWinning>): Int {
        return winningResultList.map { it.price }.reduce { acc, count -> acc + count }
    }

    fun getTotalPurchasePrice(lottoList: List<SixFortyFiveLotto>): Int{
        return lottoList.size * SixFortyFiveLotto.LOTTO_PRICE
    }

    fun getPurchaseCountByPrice(price: Int): Int {
        return price / SixFortyFiveLotto.LOTTO_PRICE
    }
}
