package lotto

import lotto.domain.*
import lotto.util.getIntegersAfterSplit
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val totalMoney = InputView.getPurchaseAmount()
    val manualCount = InputView.getManualLottoCount()
    val manualLottoNumbers = InputView.getManualLottoNumbers(manualCount)
    val manualLottos = ManualLottoGenerator(manualLottoNumbers).generateLotto(manualCount)
    val totalLottos = LottoStore.purchase(totalMoney, manualLottos, RandomLottoGenerator())
    OutputView.printLottos(totalLottos)
    val lastWinningNumbers = InputView.getLastWinningNumbers()
    val bonusBall = InputView.getBonusBall()
    val winningLotto = Lotto.fromInts(lastWinningNumbers.getIntegersAfterSplit(","))
    val lottoResult = LottoResult(totalLottos, winningLotto, LottoNumber(bonusBall))
    OutputView.printResult(lottoResult)
}
