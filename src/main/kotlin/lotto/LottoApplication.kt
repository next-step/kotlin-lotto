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
        val winningLotto = getWinningLotto()
        val bonusNumber = getBonusNumber(winningLotto)
        resultView.printEnter()

        resultView.printResult()
        val collectCounts = lottoNumberMatcher.lottoCheck(winningLotto, lottoBundle.lottoBundle, bonusNumber)
        val collectBonusCount = lottoNumberMatcher.bonusLottoCheck(winningLotto, lottoBundle.lottoBundle, bonusNumber)

        val resultGroup = lottoNumberMatcher.lottoResultGroup(collectCounts)
        resultView.printWinningResult(resultGroup, collectBonusCount)

        val winningMoney = lottoMoneyMatcher.winningMoneyCheck(collectCounts, collectBonusCount)
        val returnRatio = rateCalculator.calculateRateOfReturn(lottoBundle.inputMoney, winningMoney)
        resultView.printRateOfReturn(returnRatio)
    }

    private fun getBonusNumber(lotto: Lotto): Int {
        val bonusNumber = inputView.printInputBonusLottoNumber().toInt()
        lottoBonusNumberValidation(bonusNumber, lotto)
        return bonusNumber
    }

    private fun getWinningLotto(): Lotto {
        val lastWeekNumber = inputView.printInputLottoNumberByLastWeek()
        val lottoNumbers = splitLottoNumbers(lastWeekNumber)
        return Lotto(numbers = lottoNumbers)
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
        require(
            lastWeekNumber.replace("\\s".toRegex(), "").split(",").map { it.toInt() }.size == Lotto.COLLECT_LOTTO_SIZE
        ) {
            "로또 입력 숫자는 총 6개여야 합니다"
        }
    }

    private fun splitLottoNumbers(winningNumber: String): List<Int> {
        return winningNumber.replace("\\s".toRegex(), "").split(",").map { it.toInt() }
    }

    private fun lottoBonusNumberValidation(bonusNumber: Int, lotto: Lotto) {
        require(bonusNumber in 1..45) {
            "로또의 숫자는 1부터 45 사이의 숫자만 가능합니다."
        }
        require(!lotto.numbers.contains(bonusNumber)) {
            "보너스 숫자가 중복이 될 수 없습니다."
        }
    }
}

fun main() {
    LottoApplication(RateCalculator(), LottoNumberMatcher(), LottoMoneyMatcher()).startLottery()
}
