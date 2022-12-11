package lotto.domain

class Wallet(var krw: KRW = DEFAULT_KRW) {

    private val lottoBundle: LottoBundle = LottoBundle()

    fun insertMoney(input: String) {
        val additionKRW = KRW(input)
        krw = krw.add(additionKRW)
    }

    fun buyLottos(lottoStore: LottoStore = LottoStore()): List<Lotto> {
        lottoBundle.addAll(lottoStore.sell(krw))
        krw = KRW(0)
        return lottoBundle.lottos
    }

    fun indicateLottoStatistics(winningLotto: WinningLotto): Report {
        return lottoBundle.matchWinningLotto(winningLotto)
    }

    companion object {
        private const val DEFAULT_MONEY = 0
        val DEFAULT_KRW = KRW(DEFAULT_MONEY)
    }
}
