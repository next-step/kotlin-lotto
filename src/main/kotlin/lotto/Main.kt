package lotto

import lotto.domain.Lotto
import lotto.domain.LottoBundle
import lotto.domain.LottoNumber
import lotto.domain.LottoRecords
import lotto.domain.Purchase
import lotto.domain.StringSplit
import lotto.domain.WinningLotto
import lotto.service.AutoNumberCreateStrategy
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    // 구입금액 요청 출력
    val purchase = Purchase(InputView.inputAmount())
    OutputView.printPurchaseQuantity(purchase.quantity())

    // 구입 로또 목록 출력.
    val lottoBundle = LottoBundle.of(
        purchase.quantity(),
        AutoNumberCreateStrategy()
    )
    OutputView.printPurchaseLottoBundle(lottoBundle)

    // 지난주 당첨로또 요청 출력
    val winningNumbers = StringSplit.makeNumbersBySplit(
        InputView.inputWinningLottoNumbers()
    )

    val winningLotto = WinningLotto(
        Lotto.from(winningNumbers),
        LottoNumber.from(InputView.inputBonusNumber())
    )
    val recordsByRank = winningLotto.matchByRank(lottoBundle)
    val lottoRecords = LottoRecords.fromRank()
    // 당첨 통계 출력
    OutputView.printWinningStatistics(lottoRecords.calculateRecords(recordsByRank))
    OutputView.printRate(lottoRecords.calculateRateOfReturn(purchase.amount))
}
