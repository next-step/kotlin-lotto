package lotto.domain

import lotto.domain.Money.Companion.toMoney

class LottoServiceRound {
    private val lottoRound = LottoRound(LottoRoundElements())

    fun buyLottos(payment: Long): List<Lotto> {
        lottoRound.addNewLottos(payment.buyableCount())
        return lottoRound.getLottos()
    }

    fun allPayment(): Long = (lottoRound.getLottos().size * LOTTO_BUY_PRIZE.value)

    fun lotteryDraw(numbers: List<Int>): LottoRoundStatistics {
        val winningLotto = Lotto.of(numbers)
        return lottoRound.lotteryDraw(winningLotto)
    }

    private fun Long.buyableCount(): Int = (this / LOTTO_BUY_PRIZE.value).toInt()

    companion object {
        private val LOTTO_BUY_PRIZE = 1000L.toMoney()
    }
}
