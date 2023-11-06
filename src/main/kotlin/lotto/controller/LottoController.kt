package lotto.controller

import lotto.dto.LottoNumberGenerator
import lotto.dto.LottoNumbers
import lotto.dto.LottoNumbers.Companion.LOTTO_PRICE
import lotto.dto.LottoResult
import lotto.dto.LottoWinningNumbers
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
