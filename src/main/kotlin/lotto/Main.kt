package lotto

import lotto.domain.Lotto
import lotto.domain.LotteryResult
import lotto.domain.LottoBundle
import lotto.domain.Purchase
import lotto.domain.StringSplit
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
    val winningLotto = Lotto.from(winningNumbers)

    // 당첨 통계 출력
    val rankResult = LotteryResult.of(
        winningLotto,
        lottoBundle.bundle
    ).makeRankResult(purchase.amount)
    OutputView.printLotteryResult(rankResult)
}
