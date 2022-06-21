package lotto.controller

import lotto.controller.dto.LottoData
import lotto.domain.Lotto
import lotto.domain.LottoAmount
import lotto.domain.LottoFactory
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun handle() {
        val money = Money(InputView.inputPurchasedMoney())
        val amountOfTotalLotto = money.divide(Lotto.PRICE).also { ResultView.printPurchasedLottoNumber(it) }
        val lottoAmount = LottoAmount.createOf(
            amountOfTotalLotto = amountOfTotalLotto,
            amountOfManualLotto = InputView.inputManualLottoAmount(),
        )

        val allLottos = createAllLotto(lottoAmount)
        val winningLotto = WinningLotto(
            lotto = Lotto.of(*InputView.inputWinningLotto()),
            bonusBall = LottoNumber.valueOf(InputView.inputBonusBall()),
        )

        allLottos.getStatistics(winningLotto).also {
            ResultView.printStatistics(it.statistics)
            ResultView.printEarningRate(it.calculateEarningRate(money))
        }
    }

    private fun createAllLotto(lottoAmount: LottoAmount): Lottos {
        val manualLottos = LottoFactory.generateManualLottos(
            lottos = InputView.inputManualLottos(lottoAmount.amountOfManualLotto).map { Lotto.of(*it) }
        )

        val autoLottos = LottoFactory.generateAutoLottos(lottoAmount.amountOfAutoLotto)

        return (manualLottos + autoLottos)
            .also { ResultView.printLottos(lottoAmount, it.toLottoDatas()) }
    }
}

fun Lottos.toLottoDatas(): List<LottoData> = this.lottos.map { LottoData.of(it) }
