package lotto.domain

class Wallet(var krw: KRW = DEFAULT_KRW) {

    private var _lottos: MutableList<Lotto> = mutableListOf()

    val lottos: List<Lotto>
        get() = _lottos.toList()

    fun insertMoney(input: String) {
        val additionKRW = KRW.byInput(input)
        krw = krw.add(additionKRW)
    }

    fun buyLottos(lottoStore: LottoStore = LottoStore()): List<Lotto> {
        _lottos.addAll(lottoStore.sell(krw))
        krw = KRW(0)
        return lottos
    }

    fun indicateLottoStatistics(winningLotto: WinningLotto): WalletResult {
        val lottoResults = _lottos.map {
            winningLotto.compareWith(it)
        }.toList()

        return WalletResult(lottoResults)
    }

    companion object {
        private const val DEFAULT_MONEY = 0
        val DEFAULT_KRW = KRW(DEFAULT_MONEY)
    }
}
