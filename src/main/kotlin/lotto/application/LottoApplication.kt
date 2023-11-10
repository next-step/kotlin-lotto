package lotto.application

import lotto.domain.Charge
import lotto.domain.Lotto
import lotto.domain.LottoBuyingPrice
import lotto.domain.LottoMachine
import lotto.util.RandomRangeNumberGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val buyingPrice = InputView.readBuyingPrice()
            val lottoMachine = createLottoMachine(buyingPrice)

            val change = calculateChange(buyingPrice, lottoMachine)
            OutputView.printLottos(lottoMachine, change)

            val winningLotto = InputView.readWinningLotto()
            val lottoMatchResult = lottoMachine.getResult(winningLotto, buyingPrice)
            OutputView.printLottoResult(lottoMatchResult)
        }

        private fun createLottoMachine(buyingPrice: LottoBuyingPrice): LottoMachine {
            val lottoCount = buyingPrice.divide(Lotto.LOTTO_PRICE)
            return LottoMachine.of(
                lottoCount = lottoCount,
                numberGenerator = RandomRangeNumberGenerator
            )
        }

        private fun calculateChange(buyingPrice: LottoBuyingPrice, lottoMachine: LottoMachine): Charge {
            val lottoTotalPrice = lottoMachine.getLottoTotalPrice()
            return Charge(buyingPrice.minus(lottoTotalPrice.value))
        }
    }
}
