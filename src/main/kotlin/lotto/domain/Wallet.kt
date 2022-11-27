package lotto.domain

class Wallet(var value: Value = DEFAULT_VALUE) {

    var lottos: MutableList<Lotto> = mutableListOf()
        private set

    val money
        get() = value.money

    fun insertMoney(input: String) {
        val additionValue = Value.byInput(input)
        value = value.add(additionValue)
    }

    fun buyLottos(): List<Lotto> {
        lottos.addAll(LottoStore().sell(value))
        value = Value(0)
        return lottos
    }

    fun indicateLottoStatistics() {}

    companion object {
        private const val DEFAULT_MONEY = 0
        val DEFAULT_VALUE = Value(DEFAULT_MONEY)
    }
}
