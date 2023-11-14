package lottery.domain

class LottoGame(private val lottoMoney: LottoMoney, private val lottos: Lottos) {

    fun getLottos(): List<Lotto> {
        return lottos.lottos
    }

    fun getRanks(winningLotto: WinningLotto): Ranks {
        return Ranks(lottos, winningLotto, lottoMoney.money)
    }

    companion object {
        const val LOTTERY_PRICE = 1000
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_SIZE = 6
    }
}
