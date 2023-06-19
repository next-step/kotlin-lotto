package lotto

import lotto.domain.Lotto
import lotto.domain.LottoBundle
import lotto.utils.RateCalculator
import lotto.view.InputView
import lotto.view.ResultView

class LottoApplication(
    private val rateCalculator: RateCalculator,
    private val lottoNumberMatcher: LottoNumberMatcher,
    private val lottoMoneyMatcher: LottoMoneyMatcher
) {

    private val inputView = InputView
    private val resultView = ResultView

    fun startLottery() {
        val lottoBundle = getLottoBundleByMoney()
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
        resultView.printEnter()

        resultView.printResult()
        val collectCounts = lottoNumberMatcher.lottoCheck(winningNumbers, lottoBundle.lottoBundle, bonusNumber)
        val collectBonusCount = lottoNumberMatcher.bonusLottoCheck(winningNumbers, lottoBundle.lottoBundle, bonusNumber)

        val resultGroup = lottoNumberMatcher.lottoResultGroup(collectCounts)
        resultView.printWinningResult(resultGroup, collectBonusCount)

        val winningMoney = lottoMoneyMatcher.winningMoneyCheck(collectCounts, collectBonusCount)
        val returnRatio = rateCalculator.calculateRateOfReturn(lottoBundle.inputMoney, winningMoney)
        resultView.printRateOfReturn(returnRatio)
    }

    private fun getBonusNumber(winningNumbers: List<Int>): Int {
        val bonusNumber = inputView.printInputBonusLottoNumber().toInt()
        lottoBonusNumberValidation(bonusNumber, winningNumbers)
        return bonusNumber
    }

    private fun getWinningNumbers(): List<Int> {
        val lastWeekNumber = inputView.printInputLottoNumberByLastWeek()
        lastWeekNumberValidation(lastWeekNumber)
        return splitLottoNumbers(lastWeekNumber)
    }

    private fun getLottoBundleByMoney(): LottoBundle {
        val inputMoney = inputView.printInputLottoBuyMoney().toInt()
        resultView.printLottoCount(inputMoney)

        val lottoManager = LottoManager()

        val lottoBundle = lottoManager.buyLotto(inputMoney)
        resultView.printLottoBundle(lottoBundle)
        resultView.printEnter()
        return LottoBundle(inputMoney, lottoBundle)
    }

    private fun lastWeekNumberValidation(lastWeekNumber: String) {
        require(lastWeekNumber.replace("\\s".toRegex(), "").split(",").map { it.toInt() }.size == Lotto.COLLECT_LOTTO_SIZE) {
            "로또 입력 숫자는 총 6개여야 합니다"
        }
    }

    private fun splitLottoNumbers(winningNumber: String): List<Int> {
        return winningNumber.replace("\\s".toRegex(), "").split(",").map { it.toInt() }
    }

    private fun lottoBonusNumberValidation(bonusNumber: Int, splitNumbers: List<Int>) {
        require( bonusNumber in 1..45) {
            "로또의 숫자는 1부터 45 사이의 숫자만 가능합니다."
        }
        require( !splitNumbers.contains(bonusNumber)) {
            "보너스 숫자가 중복이 될 수 없습니다."
        }
    }
}

fun main() {
    LottoApplication(RateCalculator(), LottoNumberMatcher(), LottoMoneyMatcher()).startLottery()
}
