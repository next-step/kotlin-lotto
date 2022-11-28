package lotto.domain

class Wallet(var krw: KRW = DEFAULT_KRW) {

    var lottos: MutableList<Lotto> = mutableListOf()
        private set

    val money
        get() = krw.money

    fun insertMoney(input: String) {
        val additionKRW = KRW.byInput(input)
        krw = krw.add(additionKRW)
    }

    fun buyLottos(): List<Lotto> {
        lottos.addAll(LottoStore().sell(krw))
        krw = KRW(0)
        return lottos
    }

    fun indicateLottoStatistics(winningLotto: WinningLotto): WalletResult {
        return WalletResult(lottos.map {
            winningLotto.compareWith(it)
        }.toList())
    }

    companion object {
        private const val DEFAULT_MONEY = 0
        val DEFAULT_KRW = KRW(DEFAULT_MONEY)
    }
}
