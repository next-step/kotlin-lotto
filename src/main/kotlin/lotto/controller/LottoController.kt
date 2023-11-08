package lotto.controller

import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoNumbers
import lotto.domain.LottoResult
import lotto.domain.LottoWinningNumbers
import lotto.dto.ImmutableMoney
import lotto.dto.LottoNumber
import lotto.dto.Money
import lotto.view.View

class LottoController {
    fun run() {
        val money = Money(View.inputMoney())
        val manualLottoNumbers = buyManualLottos(money)
        val autoLottoNumbers = buyAutoLottos(money)
        showBuyLottos(manualLottoNumbers, autoLottoNumbers)
        val winningNumbers = winningNumbers()
        val result = checkResult(
            manualLottoNumbers + autoLottoNumbers,
            winningNumbers
        )
        View.outputResult(money, result)
    }

    fun runByImmutableMoney() {
        val initialMoney = ImmutableMoney.of(View.inputMoney())
        val manualCount = View.inputManualCount()
        val autoMoney = initialMoney.buy(manualCount)
        val manualLottoNumbers = View.inputManualLottoNumbers(manualCount).map {
            LottoNumbers.from(it)
        }
        val autoLottoNumbers = List(autoMoney.buyAll()) {
            LottoNumberGenerator.generate()
        }
        showBuyLottos(manualLottoNumbers, autoLottoNumbers)
        val winningNumbers = winningNumbers()
        val result = checkResult(
            manualLottoNumbers + autoLottoNumbers,
            winningNumbers
        )
        View.outputResultByImmutableMoney(initialMoney, result)
    }

    private fun buyManualLottos(money: Money): List<LottoNumbers> {
        val manualCount = View.inputManualCount()
        money.buyLottos(manualCount)
        return View.inputManualLottoNumbers(manualCount).map {
            LottoNumbers.from(it)
        }
    }

    private fun buyAutoLottos(money: Money): List<LottoNumbers> {
        val buyLottos = mutableListOf<LottoNumbers>()
        for (i in 0 until money.buyAllLottos()) {
            buyLottos.add(LottoNumberGenerator.generate())
        }
        return buyLottos
    }

    private fun checkResult(lottos: List<LottoNumbers>, winningNumber: LottoWinningNumbers): LottoResult {
        val result = LottoResult()
        lottos.forEach {
            result.updateExact(winningNumber.compareLottoNumbers(it))
        }
        return result
    }

    private fun showBuyLottos(manualLottoNumbers: List<LottoNumbers>, autoLottoNumbers: List<LottoNumbers>) {
        View.outputBuyCount(manualLottoNumbers.size, autoLottoNumbers.size)
        View.outputBuyLottoNumbers(autoLottoNumbers)
    }

    private fun winningNumbers() = LottoWinningNumbers(
        LottoNumbers.from(View.inputWinningNumber()),
        LottoNumber(View.inputBonusNumber())
    )
}
