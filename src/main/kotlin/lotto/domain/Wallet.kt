package lotto.domain

class Wallet(var krw: KRW = DEFAULT_KRW) {

    private val lottoBundle: LottoBundle = LottoBundle()

    fun buyAutoLottos(lottoStore: LottoStore = LottoStore()): List<Lotto> {
        val autoLottos = lottoStore.sell(krw)
        lottoBundle.addAll(autoLottos)
        krw = KRW(0)
        return autoLottos
    }

    fun buyManualLottos(lottoStore: LottoStore = LottoStore(), lotto: List<String>): List<Lotto> {
        val manualLottos = lottoStore.sell(krw, lotto)
        lottoBundle.addAll(manualLottos)
        krw = KRW(krw.money - lotto.size * Lotto.krw.money)
        return manualLottos
    }

    fun indicateLottoStatistics(winningLotto: WinningLotto): Report {
        return lottoBundle.matchWinningLotto(winningLotto)
    }

    companion object {
        private const val DEFAULT_MONEY = 0
        val DEFAULT_KRW = KRW(DEFAULT_MONEY)
    }
}
