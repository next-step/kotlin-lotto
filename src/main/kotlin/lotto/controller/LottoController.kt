package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoNumber
import lotto.service.InputParser
import lotto.service.LottoService
import lotto.view.LottoGameView
import lotto.view.LottoView

class LottoController(private val lottoService: LottoService) {

    fun start() {
        val lottos = buyLotto()

        val winningLotto = getLastWinningLotto()
        val bonusNumber = getBonusNumber()
        val lottoGame = LottoGame(lottos, winningLotto, bonusNumber)

        LottoGameView.printWinningStats(lottoGame.result)
    }

    private fun buyLotto(): List<Lotto> {
        val purchaseAmount = getPurchaseAmount()
        val n = purchaseAmount / LOTTO_PRICE

        val manualAmount = getManualAmount()
        require(n >= manualAmount) { "수동 구매한 로또 수[$manualAmount]가 구매 가능한 장수[$n]를 초과하였습니다." }

        val manualLottos = getManualLottos(manualAmount)

        val autoAmount = n - manualAmount

        val autoLottos = lottoService.buy(autoAmount)

        LottoGameView.printBuyAmount(manualAmount = manualAmount, autoAmount = autoAmount)

        return (manualLottos + autoLottos).onEach { LottoView(it).print() }
    }

    private fun getPurchaseAmount(): Int {
        LottoGameView.printPurchaseAmountInput()

        return InputParser.parsePurchaseAmount(requireNotNull(readLine()))
    }

    private fun getManualAmount(): Int {
        LottoGameView.printManualAmountInput()

        return InputParser.parseManualAmount(readln())
    }

    private fun getManualLottos(manualAmount: Int): List<Lotto> {
        LottoGameView.printManualNumberInput()

        return (1..manualAmount).map {
            Lotto(InputParser.parseLottoNumbers(readln()))
        }
    }

    private fun getLastWinningLotto(): Lotto {
        LottoGameView.printLastWinningNumbers()

        return Lotto(InputParser.parseLottoNumbers(readln()))
    }

    private fun getBonusNumber(): LottoNumber {
        LottoGameView.printBonusNumber()

        return InputParser.parseBonusNumber(readln())
    }

    companion object {
        private const val LOTTO_PRICE = 1_000
    }
}
