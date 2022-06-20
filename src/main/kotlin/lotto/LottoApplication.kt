package lotto

import lotto.domain.LottoPrice
import lotto.domain.LottoPurchase
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    // 구입금액 입력받기
    val price = InputView.getPrice()

    // 구입금액 validation
    val lottoPurchase = LottoPurchase()
    val lottoPrice = LottoPrice(price)

    // 구입금액에 따른 로또 개수 반환
    val lottoCount = lottoPurchase.getLottoCount(lottoPrice)
    // 로또 개수에 맞추어 로또 번호 반환
    val lottoTickets = lottoPurchase.getLottoTickets(lottoCount)
    OutputView.resultPurchaseLotto(lottoCount, lottoTickets)

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
