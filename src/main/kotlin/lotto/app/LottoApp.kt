package lotto.app

import lotto.domain.AutoLottoNumberGenerator
import lotto.domain.LottoStore
import lotto.domain.WinningStatistics
import lotto.view.InputView
import lotto.view.OutPutView

fun main() {
    val inputView = InputView()
    val resultView = OutPutView()
    val lottoStore = LottoStore()
    val numberGenerator = AutoLottoNumberGenerator()

    // 1. 구입 금액 입력 및 로또 개수 계산
    val purchaseAmount = inputView.readPurchaseAmount()
    val lottoCount = purchaseAmount.calculateLottoCount()
    val manualCount = inputView.readManualCount(lottoCount)
    val manualLottos = inputView.readManualLottos(manualCount)

    resultView.printLottoCount(lottoCount, manualCount)

    // 2. 로또 발행 및 출력
    val purchasedLottos = lottoStore.issueLottos(manualLottos, lottoCount, numberGenerator)
    resultView.printPurchasedLottos(purchasedLottos)

    // 3. 당첨 번호 입력
    val winningLotto = inputView.readWinningLotto()

    // Step 4: 당첨 통계 생성
    val winningStatistics = WinningStatistics(winningLotto)
    val statistics = winningStatistics.calculateStatistics(purchasedLottos)

    // Step 5: 당첨 통계 출력
    resultView.printStatistics(statistics)

    // Step 6: 수익률 계산 및 출력
    val profitRate = winningStatistics.profitRate(lottoCount)
    resultView.printProfitRate(profitRate)
}
