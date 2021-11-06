package lotto.presentation

import lotto.domain.BonusNumber
import lotto.domain.LottoNumber
import lotto.domain.LottoStatistics
import lotto.domain.Lottos
import lotto.domain.WinningNumber
import lotto.domain.WinningNumbers
import lotto.usecase.LottoMachine
import lotto.usecase.PurchaseAmountCalculator
import lotto.usecase.WinningsChecker

class LottoGame(
    private val lottoMachine: LottoMachine,
    private val winningsChecker: WinningsChecker,
    private val calculator: PurchaseAmountCalculator,
) {

    fun buy(
        availablePurchaseCount: Int,
        passivityLottoNumbers: List<List<Int>>,
    ): Lottos {
        val passivityCount = passivityLottoNumbers.size

        require(availablePurchaseCount >= passivityCount) { "수동으로 구매요청한 개수가 구매가능한 로또개수보다 많습니다." }

        val automaticCount = availablePurchaseCount - passivityCount

        val automaticLottos = lottoMachine.automaticBuy(automaticCount)
        val passivityLottos = lottoMachine.passivityBuy(
            passivityLottoNumbers.map { passivityLottoNumber ->
                passivityLottoNumber.map { number -> LottoNumber(number) }
            }
        )

        return Lottos(
            automaticLottos = automaticLottos,
            passivityLottos = passivityLottos,
        )
    }

    fun statistics(
        winningNumbers: List<Int>,
        lottos: Lottos,
        bonusNumber: Int,
    ): LottoStatistics {

        val winningNumber = WinningNumber(
            WinningNumbers(
                winningNumbers.map { number ->
                    LottoNumber(number)
                }),
            BonusNumber(LottoNumber(bonusNumber))
        )
        val winningStatistics = winningsChecker.confirmWinning(
            lottos = lottos.getLottos(),
            winningNumber = winningNumber
        )

        return LottoStatistics(
            totalPurchaseAmount = calculator.getTotalPurchaseAmount(lottos.getLottos()),
            winningStatistics = winningStatistics
        )
    }
}
