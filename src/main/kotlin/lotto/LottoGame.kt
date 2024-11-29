package lotto

import WinningResult
import lotto.LottoConstants.LOTTO_PRICE

class LottoGame {

    fun purchase(paidMoney : Int) : List<Lotto> {
        val purchaseTime = paidMoney / LOTTO_PRICE
        require(paidMoney >= LOTTO_PRICE) { "로또 구입 금액은 1000원 이상이어야 합니다." }

        return (1.rangeTo(purchaseTime)).map { LottoRandomGenerator().randomGenerate() }
    }

    fun calculateWinningResult(tickets: List<Lotto>, winningNumbers: Lotto): WinningResult {
        val winningStatistics = tickets.map { it.match(winningNumbers) }
            .groupBy { it }
            .mapValues { it.value.size }
            .filterKeys { it >= 3 }

        return WinningResult(winningStatistics)
    }
}
