package lotto.model

class LottoMachine(private var money: Money) {
    private lateinit var lottos: Lottos

    constructor() : this(money = Money(0))

    fun insertMoney(budget: Money) {
        money = budget
    }

    fun getAvailableCount(): Int {
        return money.getBuyableLottoCount()
    }

    fun buy(lottoNumberPool: LottoNumberPool): Lottos {
        lottos = Lottos(lottoNumberPool, getAvailableCount())
        return lottos
    }

    fun getResult(winningLotto: WinningLotto): List<Result> {
        return Coincidence.values()
            .filterNot { it.equals(Coincidence.MISS) }
            .map { Result(it, it.getMatchedCount(lottos, winningLotto)) }
    }
}
