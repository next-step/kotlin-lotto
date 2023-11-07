package lotto.controller

import lotto.domain.LottoBuyingPrice
import lotto.domain.Lottos
import lotto.util.LottoNumberGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val buyingPrice = InputView.readBuyingPrice()
            val lottos = createLottos(buyingPrice)
            val change = lottos.getChange()
            OutputView.printLottos(lottos, change)
        }

        private fun createLottos(buyingPrice: LottoBuyingPrice): Lottos {
            return Lottos(
                buyingPrice = buyingPrice,
                lottoNumberGenerator = LottoNumberGenerator
            )
        }
    }
}
