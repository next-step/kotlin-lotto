package lotto.domain

class Wallet(var krw: KRW = DEFAULT_KRW) {

    private val lottoBundle: LottoBundle = LottoBundle()

    val lottos: List<Lotto>
        get() = lottoBundle.lottos

    val manualLottoCount: Int
        get() = lottoBundle.manualCount

    val autoLottoCount: Int
        get() = lottoBundle.autoCount

    init {
        require(krw.money >= 1000) {
            "0원을 입력하여 구매할 수 있는 로또가 없습니다. 다시 입력해주세요."
        }
    }

    fun buyAutoLottos(lottoStore: LottoStore = LottoStore()) {
        krw = lottoStore.sellAutoLottos(krw, lottoBundle)
    }

    fun buyManualLottos(lottoStore: LottoStore = LottoStore(), lotto: List<String>) {
        krw = lottoStore.sellManualLottos(krw, lotto, lottoBundle)
    }

    fun indicateLottoStatistics(winningLotto: WinningLotto): Report {
        return lottoBundle.matchWinningLotto(winningLotto)
    }

    companion object {
        private const val DEFAULT_MONEY = 0
        val DEFAULT_KRW = KRW(DEFAULT_MONEY)
    }
}
