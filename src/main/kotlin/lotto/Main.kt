package lotto

import lotto.dto.LottoResult
import lotto.entity.Lotto
import lotto.entity.LottoStore
import lotto.entity.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val money = InputView("구입금액을 입력해 주세요.")
    val lottoTickets = LottoStore.ticketing(money)

    OutputView.printPurchaseQuantity(lottoTickets.size)
    OutputView.printLotto(lottoTickets)
    println()

    val winningNumbers = InputView.winningNumber("지난 주 당첨 번호를 입력해 주세요.")
    val bonusBall = InputView.bonusBall("보너스 볼을 입력해 주세요.")
    val winningNumber = WinningNumber.of(winningNumbers, bonusBall)
    val rankToHowManyWins = winningNumber.calculateLottoResults(lottoTickets)
    val lottoResult = LottoResult.of(rankToHowManyWins, lottoTickets.size * Lotto.LOTTO_PRICE)
    println()

    OutputView.printResult(lottoResult)
}
