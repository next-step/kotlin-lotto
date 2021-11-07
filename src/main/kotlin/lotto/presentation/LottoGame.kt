package lotto.presentation

import lotto.domain.WinningNumber
import lotto.domain.model.BonusNumber
import lotto.domain.model.LottoNumber
import lotto.domain.model.LottoNumbers
import lotto.domain.model.LottoStatistics
import lotto.domain.model.Lottos
import lotto.domain.model.WinningNumbers
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
        val lottoNumbers = passivityLottoNumbers.map { passivityLottoNumber ->
            val numbers = passivityLottoNumber.map { number ->
                LottoNumber(number)
            }

            LottoNumbers(numbers)
        }

        val automaticLottos = lottoMachine.buyAutomatic(automaticCount)
        val passivityLottos = lottoMachine.buyPassivity(lottoNumbers)

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
            numbers = WinningNumbers(
                winningNumbers.map { number ->
                    LottoNumber(number)
                }
            ),
            bonusNumber = BonusNumber(LottoNumber(bonusNumber)),
        )

        val winningStatistics = winningsChecker.confirmWinning(
            lottos = lottos,
            winningNumber = winningNumber,
        )

        return LottoStatistics(
            totalPurchaseAmount = calculator.getTotalPurchaseAmount(lottos),
            winningStatistics = winningStatistics,
        )
    }
}
