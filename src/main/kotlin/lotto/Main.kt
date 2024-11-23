package lotto

import lotto.domain.LottoFactory
import lotto.domain.LottoIncomeCalculator
import lotto.domain.LottoNumber
import lotto.domain.LottoService
import lotto.domain.LottoStore
import lotto.domain.Money
import lotto.domain.RandomNumberGenerator
import lotto.view.ConsoleInputView
import lotto.view.ConsoleOutputView

fun main() {
    val inputView = ConsoleInputView()
    val outputView = ConsoleOutputView()
    val lottoService = setup()

    val inputMoney = inputView.requestPrice()
    val lottos = lottoService.issue(Money(inputMoney))

    outputView.printLottoQuantity(lottos.quantity)
    outputView.printLottoNumbers(lottos)

    val inputWinningNumbers = inputView.requestWinningNumbers()
    val result = lottoService.getResult(lottos, inputWinningNumbers.map(::LottoNumber).toSet())

    outputView.printLottoResult(result)
}

private fun setup(): LottoService {
    val numberGenerator = RandomNumberGenerator()
    val lottoFactory = LottoFactory(numberGenerator)
    val lottoStore = LottoStore(lottoFactory)
    val incomeCalculator = LottoIncomeCalculator()

    return LottoService(lottoStore, incomeCalculator)
}
