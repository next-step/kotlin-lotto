package lotto.model

class LottoMachine(private var money: Money) {
    constructor() : this(money = Money(0))

    fun insertMoney(budget: Money) {
        money = budget
    }

    fun getAvailableCount(): Int {
        return money.getBuyableLottoCount()
    }

    fun buy(lottoNumberPool: LottoNumberPool): Lottos {
        return Lottos(lottoNumberPool, getAvailableCount())
    }

    fun getResult(): Map<Coincidence, Int> {
        TODO("Not yet implemented")
    }
}
