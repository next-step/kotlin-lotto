package lotto.controller

import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoNumbers
import lotto.domain.LottoNumbers.Companion.LOTTO_PRICE
import lotto.domain.LottoResult
import lotto.domain.LottoWinningNumbers
import lotto.view.View

class LottoController {
    fun run() {
        val money = View.inputMoney()
        val lottos = buyLotto(money)
        View.outputBuyCount(lottos.size)
        View.outputBuyLottoNumbers(lottos)
        val winningNumber = View.inputWinningNumber()
        val bonusNumber = View.inputBonusNumber()
        val result = checkResult(lottos, LottoWinningNumbers(winningNumber, bonusNumber))
        View.outputResult(money, result)
    }

    private fun buyLotto(money: Int): List<LottoNumbers> {
        val buyLottos = mutableListOf<LottoNumbers>()
        for (i in 0 until money / LOTTO_PRICE) {
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
}
