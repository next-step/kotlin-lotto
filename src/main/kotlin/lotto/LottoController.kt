package lotto

import lotto.domain.Lotto
import lotto.domain.LottoAnalyzer
import lotto.domain.LottoStatics
import lotto.domain.LottoStore
import lotto.view.ConsoleInputView
import lotto.view.ConsoleResultView
import lotto.view.InputView

fun main() {
    val inputView: InputView = ConsoleInputView()
    val purchaseAmount: Int = inputView.getPurchaseAmount()

    val lottos: List<Lotto> = LottoStore().buyLottos(purchaseAmount)
    val consoleResultView = ConsoleResultView()
    consoleResultView.printCountOfPurchasedLotto(lottos.size)
    consoleResultView.printLottosPickedNumbers(lottos)

    val winningNumbers: List<Int> = inputView.getWinningNumbers()
    val winLotto = Lotto(winningNumbers)

    val lottoAnalyzer = LottoAnalyzer(winLotto)
    val lottoStatics: LottoStatics = lottoAnalyzer.createLottoStatics(lottos)

    consoleResultView.printLottoStatics(lottoStatics)
}
