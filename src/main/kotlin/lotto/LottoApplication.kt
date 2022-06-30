package lotto

import lotto.domain.LottoPrice
import lotto.domain.LottoPurchase
import lotto.domain.LottoTicketCount
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoPrice = inputErrorCatch { LottoPrice(InputView.getPrice()) }

    // 구입금액에 따른 로또 개수 반환
    val lottoPurchase = LottoPurchase()
    val allLottoCount = lottoPurchase.getLottoCount(lottoPrice)

    // 수동 로또 장수 입력받기
    val manualLottoCount = inputErrorCatch { InputView.getManualLottoTicketCount(allLottoCount) }
    val manualLottoTickets = inputErrorCatch { InputView.getManualLottoNumbers(manualLottoCount) }

    val lottoTicketCount = LottoTicketCount(manualLottoCount, allLottoCount - manualLottoCount)

    // 로또 개수에 맞추어 로또 번호 반환
    val autoLottoTickets = lottoPurchase.getLottoTickets(lottoTicketCount.autoTicketCount)
    val lottoTickets = manualLottoTickets + autoLottoTickets
    OutputView.resultPurchaseLotto(lottoTicketCount, lottoTickets)

    // 지난주 로또 당첨번호 받기
    val winningLotto = inputErrorCatch { InputView.getLstWinningLotto() }

    // 당첨통계
    val lottoResults = lottoTickets.compareNumber(winningLotto)
    // 수익률
    val rateResult = lottoResults.rateOfResult(lottoPrice)

    OutputView.winningResult(lottoResults, rateResult)
}

fun <T> inputErrorCatch(action: () -> T): T {
    while (true) {
        runCatching { return action() }
            .onFailure { println("다시 입력해주세요.") }
    }
}
