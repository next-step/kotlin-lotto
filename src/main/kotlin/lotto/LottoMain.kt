package lotto

import lotto.domain.LottoLastNumbers
import lotto.domain.LottoStore
import lotto.view.InputView
import lotto.view.ResultView

/**
 * 로또 어플리케이션 메인
 *
 * 구입금액을 입력해 주세요.
 * 3456
 *
 * 수동으로 구매할 로또 수를 입력해 주세요.
 * 2
 *
 * 수동으로 구매할 번호를 입력해 주세요.
 * 1,2,3,4,5,6
 * 2,3,4,5,6,7
 *
 * 수동으로 2장, 자동으로 1개를 구매했습니다.
 * [1, 2, 3, 4, 5, 6]
 * [2, 3, 4, 5, 6, 7]
 * [3, 14, 27, 30, 32, 45]
 *
 * 지난 주 당첨 번호를 입력해 주세요.
 * 1,2,3,4,8,9
 * 보너스 볼을 입력해 주세요.
 * 10
 *
 * 당첨 통계
 * ----------
 * 3개 일치 (5000원)- 1개
 * 4개 일치 (50000원)- 1개
 * 5개 일치 (1500000원)- 0개
 * 5개 일치, 보너스 볼 일치(30000000원)- 0개
 * 6개 일치 (2000000000원)- 0개
 * 총 수익률은 18.33입니다.(기준이 1이기 때문에 결과적으로 이익이라는 의미임)
 */
fun main() {
    val inputView = InputView(reader = ::readLine, writer = ::print)
    val resultView = ResultView(writer = ::print)

    val purchaseMoney = inputView.readPurchaseMoney()
    val countOfManual = inputView.readCountOfManualLotto()
    val manualLottoTickets = inputView.readManualLottoTicket(countOfManual)

    val lottoTickets = LottoStore.buy(purchaseMoney, manualLottoTickets)
    resultView.printLottoTickets(lottoTickets)

    val lottoLastNumbers = LottoLastNumbers(
        inputView.readLastLottoTicket(),
        inputView.readBonusLottoNumber()
    )

    val lottoStatistics = lottoTickets.getLottoStatistics(lottoLastNumbers)
    resultView.printLottoStatistics(lottoStatistics)
}
