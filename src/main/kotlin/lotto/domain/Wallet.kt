package lotto.domain

class Wallet(var krw: KRW = DEFAULT_KRW) {

    private val lottoBundle: LottoBundle = LottoBundle()

    fun buyAutoLottos(lottoStore: LottoStore = LottoStore()): List<Lotto> {
        krw = lottoStore.sellAutoLottos(krw, lottoBundle)
        return lottoBundle.lottos
    }

    fun buyManualLottos(lottoStore: LottoStore = LottoStore(), lotto: List<String>): List<Lotto> {
        krw = lottoStore.sellManualLottos(krw, lotto, lottoBundle)
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
