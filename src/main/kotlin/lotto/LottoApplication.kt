package lotto

import lotto.domain.DefaultLottoGenerator
import lotto.service.LottoService
import lotto.view.input.BonusNumberInputView
import lotto.view.input.ManualLottoAmountInputView
import lotto.view.input.ManualLottosInputView
import lotto.view.input.PayIntputView
import lotto.view.input.WinningLottoInputView
import lotto.view.result.BuyResultView
import lotto.view.result.LottoResultView
import lotto.view.result.LottosView

fun main() {
    val lottoService = LottoService(DefaultLottoGenerator)

    val payAmount = PayIntputView.print()
    val manualLottoAmount = ManualLottoAmountInputView.print()
    val purchaseCountDto = lottoService.createPurchaseCount(payAmount, manualLottoAmount)

    val manualLottosDto = ManualLottosInputView.print(purchaseCountDto.manualLottoAmount)

    val lottosDto = lottoService.createLottos(purchaseCountDto, manualLottosDto)

    BuyResultView.print(purchaseCountDto)
    LottosView.print(lottosDto)

    val winningLottoDto = WinningLottoInputView.print()
    val bonusBall = BonusNumberInputView.print()
    val resultsDto = lottoService.getResults(lottosDto, winningLottoDto, bonusBall)

    LottoResultView.print(resultsDto)
}
