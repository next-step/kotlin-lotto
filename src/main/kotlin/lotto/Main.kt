package lotto

import lotto.domain.LottoFactory
import lotto.domain.LottoIncomeCalculator
import lotto.domain.LottoNumber
import lotto.domain.LottoOrder
import lotto.domain.LottoService
import lotto.domain.LottoStore
import lotto.domain.Money
import lotto.domain.RandomNumberGenerator
import lotto.domain.WinningLotto
import lotto.view.ConsoleInputView
import lotto.view.ConsoleOutputView

fun main() {
    val inputView = ConsoleInputView()
    val outputView = ConsoleOutputView()
    val lottoService = setup()

    val inputMoney = inputView.requestPrice()
    val manualLottoCount = inputView.requestManualLottoCount()
    val manualLottoNumbers = inputView.requestManualLottoNumbers(manualLottoCount)
    val lottoOrder = LottoOrder(Money(inputMoney), manualLottoCount, manualLottoNumbers)

    val lottos = lottoService.issue(lottoOrder)

    outputView.printLottoQuantity(lottos.quantity)
    outputView.printLottoNumbers(lottos)

    val inputWinningNumbers = inputView.requestWinningNumbers()
    val inputBonusNumber = inputView.requestBonusNumber()

    val winningLottoNumbers = inputWinningNumbers.map(::LottoNumber).toSet()
    val bonusLottoNumber = LottoNumber(inputBonusNumber)

    val result =
        lottoService.getResult(
            lotto = lottos,
            winningLotto = WinningLotto(winningLottoNumbers, bonusLottoNumber),
        )

    outputView.printLottoResult(result)
}

private fun setup(): LottoService {
    val numberGenerator = RandomNumberGenerator()
    val lottoFactory = LottoFactory(numberGenerator)
    val lottoStore = LottoStore(lottoFactory)
    val incomeCalculator = LottoIncomeCalculator()

    return LottoService(lottoStore, incomeCalculator)
}
