package lotto

import lotto.domain.KRW
import lotto.domain.Wallet
import lotto.domain.WinningLotto
import lotto.views.InputView
import lotto.views.ResultView
import java.lang.Exception

class LottoController {

    fun run() {
        val wallet = createWallet()
        buyLottos(wallet)
        val winningLotto = createWinningLotto()
        val report = wallet.indicateLottoStatistics(winningLotto)
        ResultView.printResult(report)
    }

    private fun createWallet(): Wallet {
        return try {
            val money = KRW(InputView.insertMoney())
            require(money.money >= 1000) {
                "0원을 입력하여 구매할 수 있는 로또가 없습니다. 다시 입력해주세요."
            }
            Wallet(money)
        } catch (e: Exception) {
            ResultView.printErrorMessage(e)
            createWallet()
        }
    }

    private fun createWinningLotto(): WinningLotto {
        return try {
            val winningLottoNumbers = InputView.getWinningLottoNumbers()
            val winningBonusNumber = InputView.getBonusNumber()
            return WinningLotto.byInput(winningLottoNumbers, winningBonusNumber)
        } catch (e: Exception) {
            ResultView.printErrorMessage(e)
            createWinningLotto()
        }
    }

    private fun buyLottos(wallet: Wallet) {
        return try {
            val manualCount = InputView.getManualLottoCount().toInt()
            val manualLottoNumbers = InputView.getManualLottos(manualCount)

            val manualLottos = wallet.buyManualLottos(lotto = manualLottoNumbers)
            val autoLottos = wallet.buyAutoLottos()
            ResultView.printLottos(manualLottos.size, autoLottos)
        } catch (e: Exception) {
            ResultView.printErrorMessage(e)
            buyLottos(wallet)
        }
    }
}
