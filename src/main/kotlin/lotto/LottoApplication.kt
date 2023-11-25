package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.WinningLottoNumbers
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseMoney = InputView.inputPurchaseMoney()

    val lottoGame = LottoGame(purchaseMoney)

    ResultView.printPurchasedLottos(lottoGame.lottoTickets)

    val winningLottoNumbers = WinningLottoNumbers(
        lottoNumbers = LottoNumbers.of(InputView.inputWinningLottoNumbers()),
        bonusLottoNumber = LottoNumber(InputView.inputBonusLottoNumber())
    )

    val lottoGameResult = lottoGame.generateLottoGameResult(winningLottoNumbers)

    ResultView.printLottoGameResult(lottoGameResult)
}
