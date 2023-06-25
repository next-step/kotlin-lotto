package lotto

import lotto.domain.Lotto
import lotto.domain.LottoAnalyzer
import lotto.domain.LottoStatics
import lotto.domain.LottoStore
import lotto.domain.WinLotto
import lotto.view.ConsoleInputView
import lotto.view.ConsoleResultView
import lotto.view.InputView

fun main() {
    val inputView: InputView = ConsoleInputView()
    val purchaseAmount: Int = inputView.getPurchaseAmount()
    val countOfPurchaseManually: Int = inputView.getCountOfPurchaseManually()
    val numbersOfManuallyLotto: List<List<Int>> = inputView.getNumbersOfManuallyLotto(countOfPurchaseManually)

    val lottoStore = LottoStore()
    val lottos: List<Lotto> = lottoStore.buyLottos(purchaseAmount, numbersOfManuallyLotto)
    val consoleResultView = ConsoleResultView()
    consoleResultView.printCountOfPurchasedLotto(lottos.size)
    consoleResultView.printLottosPickedNumbers(lottos)

    val winningNumbers: List<Int> = inputView.getWinningNumbers()
    val bonusNumber = inputView.getBonusNumber()
    val winLotto = WinLotto(winningNumbers, bonusNumber)

    val lottoAnalyzer = LottoAnalyzer(winLotto, lottoStore.lottoPrice)
    val lottoStatics: LottoStatics = lottoAnalyzer.createLottoStatics(lottos)

    consoleResultView.printLottoStatics(lottoStatics)
}
