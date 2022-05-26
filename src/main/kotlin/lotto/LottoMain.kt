package lotto

import lotto.domain.LottoStatistics
import lotto.domain.LottoStore
import lotto.domain.LottoTicket
import lotto.view.InputView
import lotto.view.ResultView

/**
 * 로또 어플리케이션 메인
 *
 * 구입금액을 입력해 주세요.
 * 5000
 * 5개를 구매했습니다.
 * [7, 22, 24, 27, 36, 38]
 * [1, 11, 13, 24, 34, 45]
 * [20, 25, 34, 36, 43, 44]
 * [1, 8, 16, 33, 38, 39]
 * [23, 25, 28, 36, 40, 43]
 *
 * 지난 주 당첨 번호를 입력해 주세요.
 * 3,6,9,33,44,45
 *
 * 당첨 동계
 * ----------
 * 3개 일치 (5000원)- 0개
 * 4개 일치 (50000원)- 0개
 * 5개 일치 (1500000원)- 0개
 * 6개 일치 (2000000000원)- 0개
 * 총 수익률은 0.00입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
 */
fun main() {
    val inputView = InputView(reader = ::readLine, writer = ::print)
    val resultView = ResultView(writer = ::print)

    val purchaseMoney = inputView.readPurchaseMoney()
    val (lottoTickets, changes) = LottoStore.buy(purchaseMoney)
    resultView.printLottoTickets(lottoTickets)

    val lastLottoTicket = inputView.readLastLottoNumbers().run { LottoTicket(this) }
    val lastLottoBonusNumber = inputView.readBonusLottoNumber()

    val lottoStatistics = LottoStatistics(lottoTickets, lastLottoTicket, lastLottoBonusNumber)
    resultView.printLottoStatistics(lottoStatistics)

    val actualPurchaseMoney = purchaseMoney - changes
    resultView.printStatisticsProfit(lottoStatistics, actualPurchaseMoney)
}
