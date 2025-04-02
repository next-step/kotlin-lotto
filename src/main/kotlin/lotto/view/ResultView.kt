package lotto.view

import lotto.Lotto

class ResultView {
    fun printProfit(profit: Double) {
        println(MESSAGE_PROFIT.format(profit))
    }

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach { printLotto(it) }
    }

    private fun printLotto(lotto: Lotto) {
        println(lotto.lottoNumbers.toString())
    }

    companion object {
        private const val MESSAGE_PROFIT = "Total return rate is %d"
    }
}
