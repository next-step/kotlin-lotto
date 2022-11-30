package lotto.domain

class Wallet(var krw: KRW = DEFAULT_KRW) {

    var lottos: MutableList<Lotto> = mutableListOf()
        private set

    fun insertMoney(input: String) {
        val additionKRW = KRW.byInput(input)
        krw = krw.add(additionKRW)
    }

    fun buyLottos(lottoStore: LottoStore = LottoStore()): List<Lotto> {
        lottos.addAll(lottoStore.sell(krw))
        krw = KRW(0)
        return lottos
    }

    fun indicateLottoStatistics(winningLotto: WinningLotto): WalletResult {
        val lottoResults = lottos.map {
            winningLotto.compareWith(it)
        }.toList()

        return WalletResult(lottoResults)
    }

    companion object {
        private const val DEFAULT_MONEY = 0
        val DEFAULT_KRW = KRW(DEFAULT_MONEY)
    }
}
