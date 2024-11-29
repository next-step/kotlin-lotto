package lotto

import lotto.LottoConstants.LOTTO_PRICE

class LottoGame {

    fun purchase(paidMoney : Int) : List<Lotto> {
        val purchaseTime = paidMoney / LOTTO_PRICE
        return (1.rangeTo(purchaseTime)).map { LottoRandomGenerator().randomGenerate() }
    }

    fun checkWinning(tickets: List<Lotto>, winningNumbers: Lotto): Map<Int, Int> {
        return tickets.map { it.match(winningNumbers) }
            .groupBy { it }
            .mapValues { it.value.size }
            .filterKeys { it >= 3 }
    }
}
