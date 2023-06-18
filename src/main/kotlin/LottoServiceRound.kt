import Money.Companion.toMoney

class LottoServiceRound {
    private val lottoRound = LottoRound(LottoRoundElements())

    fun buyLottos(payment: Money): List<Lotto> {
        lottoRound.addNewLottos(payment.buyableCount())
        return lottoRound.getLottos()
    }

    fun allPayment(): Money = (lottoRound.getLottos().size * LOTTO_BUY_PRIZE.value).toMoney()

    fun lotteryDraw(numbers: List<Int>): LottoRoundStatistics {
        val winningLotto = Lotto.of(numbers)
        return lottoRound.lotteryDraw(winningLotto)
    }

    private fun Money.buyableCount(): Int = (value / LOTTO_BUY_PRIZE.value).toInt()

    companion object {
        private val LOTTO_BUY_PRIZE = 1000L.toMoney()
    }
}
