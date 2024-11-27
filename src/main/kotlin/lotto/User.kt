package lotto

class User(private var amount: Amount) {
    val totalLottos: Lottos
        get() = autoLottos
    val totalLottoSize: Int
        get() = autoLottos.size
    val totalBuyAmount: Amount
        get() = autoLottos.totalAmount
    private lateinit var autoLottos: Lottos

    fun buyLotto(autoMachine: (amount: Amount) -> Lottos) {
        autoLottos = autoMachine(amount)
        amount = amount.minus(autoLottos.totalAmount)
    }

    fun match(
        lastWeekNumbers: Lotto,
        bonus: Boolean,
    ): Ranks {
        return Ranks.fromGroupBy(totalLottos.match(lastWeekNumbers, bonus))
    }
}
