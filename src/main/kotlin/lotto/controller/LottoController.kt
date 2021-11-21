package lotto.controller

import lotto.domain.BonusBall
import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoGeneratorImpl
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.view.InputView
import lotto.view.OutputView

object LottoController {

    private const val NOT_ENOUGH_MONEY_MESSAGE = "돈이 부족합니다."

    fun start() {
        val totalMoney = Money.from(InputView.getMoney())

        val purchasedManualLottoMoney = Lotto.getMoneyByLottoCount(InputView.inputManualLottoCount())
        require(totalMoney >= purchasedManualLottoMoney) { NOT_ENOUGH_MONEY_MESSAGE }

        val purchasedManualLottos = purchaseManualLottos(purchasedManualLottoMoney)
        val purchasedAutoLottos = purchaseAutoLottos(Money.from(totalMoney - purchasedManualLottoMoney))

        OutputView.showLottos(purchasedManualLottos, purchasedAutoLottos)
        val mergedLottos = Lottos.from(purchasedManualLottos.lottos + purchasedAutoLottos.lottos)

        showLottoResults(mergedLottos, totalMoney)
    }

    private fun purchaseManualLottos(money: Money): Lottos {
        return Lottos.from(InputView.inputManualLotto(Lotto.getPurchasedLottoCount(money)))
    }

    private fun purchaseAutoLottos(money: Money): Lottos {
        val lottoGenerator: LottoGenerator = LottoGeneratorImpl()
        return Lottos.of(lottoGenerator, money)
    }

    private fun showLottoResults(mergedLottos: Lottos, money: Money) {
        val winningLotto = Lotto.from(InputView.inputWinningNumbers())
        val bonusBall = BonusBall.of(InputView.inputBonusBall(), winningLotto)
        val lottoResult = mergedLottos.match(winningLotto, bonusBall)

        OutputView.printOverview(lottoResult)
        OutputView.printProfitPercent(lottoResult, money)
    }
}
