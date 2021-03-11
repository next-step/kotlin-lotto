package lotto.model

import java.math.BigDecimal

class LottoMachine(private var money: Money) {
    private lateinit var lottos: Lottos
    private lateinit var winningLotto: WinningLotto

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
        this.winningLotto = winningLotto

        return Coincidence.values()
            .filterNot { it == Coincidence.MISS }
            .map { Result(it, it.getMatchedCount(lottos, winningLotto)) }
    }

    fun getEarningRate(): BigDecimal {
        return lottos.getEarningRate(winningLotto.winningLotto)
    }
}
