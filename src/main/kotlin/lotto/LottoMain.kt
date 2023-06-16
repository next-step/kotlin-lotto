package lotto

import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoNumbers = LottoMachine.buyLottoes(InputView.getBuyAmount())
    ResultView.showBuyResult(lottoNumbers)

    val ranking = LottoMachine.setRanking(InputView.getWinNumbers())
    ResultView.showGameResult(ranking)
}
