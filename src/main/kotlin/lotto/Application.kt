package lotto

import lotto.domain.*
import lotto.util.getIntegersAfterSplit
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val manualCount = InputView.getManualLottoCount()
    val manualLottoNumbers = InputView.getManualLottoNumbers(manualCount)
    val autoLottos = LottoStore.purchase(purchaseAmount - manualCount * 1000, RandomLottoGenerator())
    val manualLottos = manualLottoNumbers
        .map { LottoStore.purchase(1000, ManualLottoGenerator(it)) }
        .flatMap { it.getLottos() }
    val totalLottos = autoLottos.addLottos(manualLottos)
    OutputView.printLottos(totalLottos)
    val lastWinningNumbers = InputView.getLastWinningNumbers()
    val bonusBall = InputView.getBonusBall()
    val winningLotto = Lotto.fromInts(lastWinningNumbers.getIntegersAfterSplit(","))
    val lottoResult = LottoResult(totalLottos, winningLotto, LottoNumber(bonusBall))
    OutputView.printResult(lottoResult)
}
