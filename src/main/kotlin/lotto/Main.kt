package lotto

import lotto.domain.Lotto
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

private val lottoGame = LottoGame()
private val inputView = InputView()
private val outputView = OutputView()

fun main() {
    val lottos = generateLottos()
    val winningLotto = generateWinningLotto()
    val lottoResult = lottoGame.play(lottos, winningLotto)
    outputView.printResult(lottoResult)
}

private fun generateLottos(): List<Lotto> {
    val inputMoney = inputView.inputMoney()
    val boughtMoney = lottoGame.parseInputMoney(inputMoney)
    val inputManualLottoAmount = inputView.inputManualLottoAmount()
    val manualLottoAmount = lottoGame.parseInputManualLottoAmount(inputManualLottoAmount)

    val inputManualLottoNumbers = inputView.inputManualLottoNumbers(manualLottoAmount)
    val lottos = lottoGame.generateLottos(boughtMoney, manualLottoAmount, inputManualLottoNumbers)
    outputView.printLottos(boughtMoney, manualLottoAmount, lottos)

    return lottos
}

private fun generateWinningLotto(): WinningLotto {
    val inputWinningLottoNumbers = inputView.inputWinningLottoNumbers()
    val inputBonusNumber = inputView.inputBonusNumber()

    return lottoGame.generateWinningLotto(inputWinningLottoNumbers, inputBonusNumber)
}