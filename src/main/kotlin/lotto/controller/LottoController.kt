package lotto.controller

import lotto.domain.LottoBuyingPrice
import lotto.domain.LottoStorage
import lotto.util.LottoNumberGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val buyingPrice = InputView.readBuyingPrice()
            val lottoStorage = createLottoStorage(buyingPrice)
            val change = lottoStorage.getChange()
            OutputView.printLottos(lottoStorage, change)

            val winningLotto = InputView.readWinningLotto()
            val lottoMatchResult = lottoStorage.getResult(winningLotto)
            OutputView.printLottoResult(lottoMatchResult)
        }

        private fun createLottoStorage(buyingPrice: LottoBuyingPrice): LottoStorage {
            return LottoStorage(
                buyingPrice = buyingPrice,
                lottoNumberGenerator = LottoNumberGenerator
            )
        }
    }
}
