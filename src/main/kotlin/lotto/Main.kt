package lotto

import lotto.entity.Lotto
import lotto.entity.LottoStore
import lotto.entity.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView
import lotto.workflow.MakeLottoResult

fun main() {
    val money = InputView.getPurchaseCost("구입금액을 입력해 주세요.")
    val lottoTickets = LottoStore.ticketing(money)

    OutputView.printPurchaseQuantity(lottoTickets.size)
    OutputView.printLotto(lottoTickets)
    println()

    val winningNumbers = InputView.winningNumber("지난 주 당첨 번호를 입력해 주세요.")
    val bonusBall = InputView.bonusBall("보너스 볼을 입력해 주세요.")
    val winningNumber = WinningNumber.of(winningNumbers, bonusBall)
    val rankToHowManyWins = winningNumber.calculateLottoResults(lottoTickets)
    val makeLottoResult = MakeLottoResult(rankToHowManyWins, (lottoTickets.size * Lotto.LOTTO_PRICE).toDouble())
    println()

    OutputView.printResult(makeLottoResult)
}
