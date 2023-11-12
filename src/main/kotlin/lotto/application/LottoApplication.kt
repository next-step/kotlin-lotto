package lotto.application

import lotto.domain.purchase.Charge
import lotto.domain.Lotto
import lotto.domain.purchase.LottoBuyingPrice
import lotto.domain.LottoMachine
import lotto.domain.number.RandomLottoLottoNumberGenerator
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val buyingPrice = InputView.readBuyingPrice()
            val manualLottos = createManualLottos(buyingPrice)
            val lottoMachine = createLottoMachine(buyingPrice, manualLottos)

            val change = calculateChange(buyingPrice, lottoMachine)
            OutputView.printLottos(lottoMachine, change)

            val winningLotto = createWinningLotto()
            val lottoMatchResult = lottoMachine.getResult(winningLotto, buyingPrice)
            OutputView.printLottoResult(lottoMatchResult)
        }

        private fun createManualLottos(buyingPrice: LottoBuyingPrice): List<Lotto> {
            val manualLottoCount = InputView.readManualLottoCount()
            buyingPrice.validateManualLottoPurchase(manualLottoCount)
            return InputView.readManualLottos(manualLottoCount)
        }

        private fun createLottoMachine(buyingPrice: LottoBuyingPrice, manualLottos: List<Lotto>): LottoMachine {
            val autoLottoCount = buyingPrice.divide(Lotto.LOTTO_PRICE).minus(manualLottos.size)
            return LottoMachine.of(
                autoLottoCount = autoLottoCount,
                lottoNumberGenerator = RandomLottoLottoNumberGenerator,
                manualLotto = manualLottos
            )
        }

        private fun calculateChange(buyingPrice: LottoBuyingPrice, lottoMachine: LottoMachine): Charge {
            val lottoTotalPrice = lottoMachine.getLottoTotalPrice()
            return Charge(buyingPrice.minus(lottoTotalPrice.value))
        }

        private fun createWinningLotto(): WinningLotto {
            val winningLottoNumbers = InputView.readWinningLotto()
            val bonusBall = InputView.readBonusBall()
            return WinningLotto(winningLottoNumbers, bonusBall)
        }
    }
}
