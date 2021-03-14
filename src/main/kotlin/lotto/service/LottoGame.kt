package lotto.service

import lotto.model.game.Lotto
import lotto.model.game.LottoTicket
import lotto.model.game.Lottos
import lotto.model.game.WinningLotto
import lotto.model.input.Money
import lotto.model.result.Coincidence
import lotto.model.result.Result

class LottoGame {
    fun ready(budget: Int): Int {
        val money = Money(budget)
        return money.getBuyableLottoCount()
    }

    fun buy(autoCount: Int, manualNumbers: List<List<Int>>): Lottos {
        val lottoByManual = getLottosByManualNumbers(manualNumbers)
        val lottoByAuto = getLottosByAutoCount(autoCount)

        return lottoByManual.add(lottoByAuto)
    }

    fun getResult(lottos: Lottos, winningLotto: WinningLotto): Map<Coincidence, Result> {
        val lottoTicket = LottoTicket(lottos, winningLotto)

        return Coincidence.values()
            .filterNot { it == Coincidence.MISS }
            .map { it to Result(lottoTicket.getMatchedLottoCount(it)) }
            .toMap()
    }

    private fun getLottosByManualNumbers(lottos: List<List<Int>>): Lottos {
        val manualLottos = lottos.map { Lotto(it) }
        return Lottos(manualLottos)
    }

    private fun getLottosByAutoCount(autoCount: Int): Lottos {
        return Lottos(autoCount)
    }
}
