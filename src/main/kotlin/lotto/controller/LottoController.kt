package lotto.controller

import lotto.dto.LottoNumber
import lotto.dto.LottoNumberGenerator
import lotto.dto.LottoResult
import lotto.utils.LOTTO_PRICE
import lotto.view.View

class LottoController {
    fun run() {
        val money = View.inputMoney()
        val lottos = buyLotto(money)
        View.outputBuyCount(lottos.size)
        View.outputBuyLottoNumbers(lottos)
        val winningNumber = View.inputWinningNumber()
        val result = checkResult(lottos, winningNumber)
        View.outputResult(money, result)
    }

    private fun buyLotto(money: Int): List<LottoNumber> {
        val buyLottos = mutableListOf<LottoNumber>()
        for (i in 0 until money / LOTTO_PRICE) {
            buyLottos.add(LottoNumberGenerator.generate())
        }
        return buyLottos
    }

    private fun checkResult(lottos: List<LottoNumber>, winningNumber: LottoNumber): LottoResult {
        val result = LottoResult()
        lottos.forEach {
            result.updateExact(it.compare(winningNumber))
        }
        return result
    }
}
