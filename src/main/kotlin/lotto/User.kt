package lotto

class User(private var amount: Amount) {
    val totalLottos: Lottos
        get() = manualLottos.merge(autoLottos)
    val totalLottoSize: Int
        get() = totalLottos.size
    val totalBuyAmount: Amount
        get() = totalLottos.totalAmount
    private var manualLottos: Lottos = Lottos(emptyList())
    private var autoLottos: Lottos = Lottos(emptyList())

    fun buyAutoLotto(autoMachine: (amount: Amount) -> Lottos) {
        autoLottos = autoMachine(amount)
        amount = amount.minus(autoLottos.totalAmount)
    }

    fun match(
        lastWeekNumbers: Lotto,
        bonus: Boolean,
    ): Ranks {
        return Ranks.fromGroupBy(totalLottos.match(lastWeekNumbers, bonus))
    }

    fun buyManualNumbers(lottos: Lottos) {
        val requiredAmount = lottos.totalAmount
        if (amount.isLessThan(requiredAmount)) {
            throw IllegalArgumentException("수동 구매 금액이 부족합니다.")
        }
        manualLottos = lottos
        amount = amount.minus(requiredAmount)
    }
}
