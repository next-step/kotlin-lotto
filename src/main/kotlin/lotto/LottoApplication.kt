package lotto

import lotto.domain.LottoPrice
import lotto.domain.LottoPurchase
import lotto.domain.LottoTicketCount
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoPrice = LottoPrice(InputView.getPrice())

    // 구입금액에 따른 로또 개수 반환
    val lottoPurchase = LottoPurchase()
    val allLottoCount = lottoPurchase.getLottoCount(lottoPrice)

    // 수동 로또 장수 입력받기
    val manualLottoCount = InputView.getManualLottoCount(allLottoCount)

    val lottoTicketCount = LottoTicketCount(manualLottoCount, allLottoCount - manualLottoCount)

    // 로또 개수에 맞추어 로또 번호 반환
    val lottoTickets = lottoPurchase.getLottoTickets(lottoTicketCount.autoTicketCount)
    OutputView.resultPurchaseLotto(lottoTicketCount, lottoTickets)

    // 지난주 로또 당첨번호 받기
    val lastWinningNumbers = InputView.getLastWinningNumbers()
    val bonusNumber = InputView.getBonusNumber()

    val winningLotto = WinningLotto(lastWinningNumbers, bonusNumber)

    // 당첨통계
    val lottoResults = lottoTickets.compareNumber(winningLotto)
    // 수익률
    val rateResult = lottoResults.rateOfResult(lottoPrice)

    OutputView.winningResult(lottoResults, rateResult)
}
