package lotto

import lotto.domain.*
import lotto.util.getIntegersAfterSplit
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val totalMoney = InputView.getPurchaseAmount()
    val manualCount = InputView.getManualLottoCount()
    val manualLottoNumbers = InputView.getManualLottoNumbers(manualCount)
    val manualLottoMoney = manualCount * Lotto.LOTTO_PRICE
    val manualLottos = LottoStore.purchase(manualLottoMoney, ManualLottoGenerator(*manualLottoNumbers.toTypedArray()))
    val autoLottos = LottoStore.purchase(totalMoney - manualLottoMoney, RandomLottoGenerator())
    val totalLottos = autoLottos + manualLottos
    OutputView.printLottos(totalLottos)
    val lastWinningNumbers = InputView.getLastWinningNumbers()
    val bonusBall = InputView.getBonusBall()
    val winningLotto = Lotto.fromInts(lastWinningNumbers.getIntegersAfterSplit(","))
    val lottoResult = LottoResult(totalLottos, winningLotto, LottoNumber(bonusBall))
    OutputView.printResult(lottoResult)
}
