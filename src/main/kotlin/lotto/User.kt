package lotto

class User(private var amount: Amount) {
    val totalLottos: Lottos
        get() = autoLottos
    val totalLottoSize: Int
        get() = autoLottos.size
    private val totalBuyAmount: Amount
        get() = autoLottos.totalAmount
    private lateinit var autoLottos: Lottos

    fun buyLotto(autoMachine: (amount: Amount) -> Lottos) {
        autoLottos = autoMachine(amount)
        amount = amount.minus(autoLottos.totalAmount)
    }

    fun statistics(
        lastNumbers: Lotto,
        bonusNumber: LottoNumber,
    ): LottoStatistics {
        val isBonus = lastNumbers.contains(bonusNumber)
        val ranks: Ranks = Ranks.fromGroupBy(totalLottos.match(lastNumbers, isBonus))
        return LottoStatistics(ranks, totalBuyAmount)
    }
}
