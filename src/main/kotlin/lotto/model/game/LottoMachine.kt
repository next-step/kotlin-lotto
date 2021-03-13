package lotto.model.game

import lotto.model.result.Coincidence
import lotto.model.input.Money
import lotto.model.result.Result
import java.math.BigDecimal

class LottoMachine(private var money: Money = Money(0)) {
    private lateinit var lottos: Lottos
    private lateinit var winningLotto: WinningLotto

    fun insertMoney(budget: Money): Int {
        money = budget
        return money.getBuyableLottoCount()
    }

    fun buyByManual(lottos: Lottos) {
        this.lottos = lottos
    }

    fun buy(lottoCount: Int): Lottos {
        val lottoByAuto = Lottos(lottoCount)
        val newLottos: List<Lotto> = this.lottos.lottos
        val list = newLottos.toMutableList()
        lottoByAuto.lottos.forEach { list.add(it) }
        lottos = Lottos(list)

        return lottos
    }

    fun getResult(winningLotto: WinningLotto): Map<Coincidence, Result> {
        this.winningLotto = winningLotto
        val lottoTicket = LottoTicket(lottos, winningLotto)

        return Coincidence.values()
            .filterNot { it == Coincidence.MISS }
            .map { it to Result(lottoTicket.getMatchedLottoCount(it)) }
            .toMap()
    }

    fun getEarningRate(): BigDecimal {
        return lottos.getEarningRate(winningLotto.winningLotto)
    }
}
