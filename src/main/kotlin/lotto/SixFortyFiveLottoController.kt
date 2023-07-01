package lotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoPurchases
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoStore
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningLotto
import lotto.sixFortyFiveNumberLotto.merge
import lotto.view.input.LottoPurchasePriceInputView
import lotto.view.input.sixFortyFiveNumberLotto.SixFortyFiveLottoBonusInputView
import lotto.view.input.sixFortyFiveNumberLotto.SixFortyFiveLottoLastWinNumInputView
import lotto.view.input.sixFortyFiveNumberLotto.SixFortyFiveManualLottoCountInputView
import lotto.view.input.sixFortyFiveNumberLotto.SixFortyFiveManualLottoesInputView
import lotto.view.output.sixFortyFiveNumberLotto.SixFortyFiveBonusResultOutputView
import lotto.view.output.sixFortyFiveNumberLotto.SixFortyFiveLottoOutputView

class SixFortyFiveLottoController(
    private val lottoStore: SixFortyFiveLottoStore = SixFortyFiveLottoStore(),
) {
    fun start() {
        // 구입금액 입력
        val purchasePrice = LottoPurchasePriceInputView().value
        val purchaseCount = lottoStore.getPurchaseCountByPrice(purchasePrice)

        // 수동으로 구매할 로또 수 입력 & 수동 로또 purchase 생성
        val manualLottoCount = SixFortyFiveManualLottoCountInputView().value
        val manualPurchases = SixFortyFiveManualLottoesInputView(manualLottoCount).value

        // 전체 구입 금액에서 생성된 수동로또 수를 제외한 만큼 자동로또 생성
        val autoPurchases = SixFortyFiveLottoPurchases.ofAutoFromManual(purchaseCount, manualPurchases)
        val mergedPurchases = manualPurchases.merge(autoPurchases)

        // 자동+수동 로또들의 purchases를 통한 로또 구매 진행
        val lottoList = lottoStore.purchase(mergedPurchases)
        SixFortyFiveLottoOutputView(lottoList, autoPurchases.value.size, manualLottoCount)

        // 지난주 당첨번호 입력
        val lastWinningNumbers = SixFortyFiveLottoLastWinNumInputView().value

        // 보너스볼 입력
        val bonusWinningNumber = SixFortyFiveLottoBonusInputView().value
        val winningLotto = SixFortyFiveWinningLotto(lastWinningNumbers, bonusWinningNumber)

        // 당첨통계 출력
        SixFortyFiveBonusResultOutputView(lottoList, winningLotto)
    }
}
