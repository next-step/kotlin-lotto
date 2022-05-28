package lotto

import kotlin.math.round

object LottoStatistics {
    fun calculateWinningTotalMoney(lottoNumbers: List<Lotto>, winningLottoNumbers: List<Int>): Int {
        return lottoNumbers.sumOf { lotto ->
            val count = lotto.getCountWithWinningLottoNumber(winningLottoNumbers)
            lotto.exchangeCountToMoney(count)
        }
    }

    fun calculateEarningRate(money: Int, winningTotalMoney: Int): Double {
        return round(winningTotalMoney / money.toDouble() * 100) / 100
    }
}
