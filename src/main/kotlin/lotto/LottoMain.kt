package lotto

import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoNumbers = LottoMachine.buyLottoes(InputView.inputBuyAmount())
    ResultView.showBuyResult(lottoNumbers)

    val winNumber = InputView.inputWinNumber()
    val bonusNumber = InputView.inputBonusNumber(winNumber)
    LottoMachine.setWinNumbers(winNumber, bonusNumber)

    val ranking = LottoMachine.getRanking()
    ResultView.showGameResult(ranking)
}
