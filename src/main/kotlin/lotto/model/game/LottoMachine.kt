package lotto.model.game

import lotto.model.result.Coincidence
import lotto.model.input.Money
import lotto.model.result.Result
import java.math.BigDecimal

class LottoMachine(private var money: Money) {
    private lateinit var lottos: Lottos
    private lateinit var winningLotto: WinningLotto

    constructor() : this(money = Money(0))

    fun insertMoney(budget: Money): Int {
        money = budget
        return money.getBuyableLottoCount()
    }

    fun buy(lottoCount: Int): Lottos {
        lottos = Lottos(LOTTO_NUMBER_POOL, lottoCount)
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

    companion object {
        private val LOTTO_NUMBER_POOL = LottoNumberPool
    }
}
