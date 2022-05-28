package lotto

import kotlin.math.round

class LottoBuyer {
    private val _lottoNumbers = ArrayList<Lotto>()
    val lottoNumbers
        get() = _lottoNumbers

    fun buyLotto(money: Int) {
        _lottoNumbers.clear()
        _lottoNumbers.addAll(getLottoNumbers(checkBuyLottoCount(money)))
    }

    private fun checkBuyLottoCount(money: Int): Int {
        return money / PRICE
    }

    private fun getLottoNumbers(count: Int): List<Lotto> {
        val result = ArrayList<Lotto>()
        for (i in 1..count) {
            result.add(Lotto().also { it.getLottoNumber() })
        }
        return result
    }

    fun calculateWinningTotalMoney(winningLottoNumbers: List<Int>): Int {
        return _lottoNumbers.sumOf { lotto ->
            val count = lotto.getCountWithWinningLottoNumber(winningLottoNumbers)
            lotto.exchangeCountToMoney(count)
        }
    }

    fun calculateEarningRate(money: Int, winningTotalMoney: Int): Double {
        return round(winningTotalMoney / money.toDouble() * 100) / 100
    }

    companion object {
        const val PRICE = 1000
    }
}
