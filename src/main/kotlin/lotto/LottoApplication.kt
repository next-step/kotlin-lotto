package lotto

import lotto.domain.Lotto
import lotto.domain.LottoBundle
import lotto.domain.LottoNumber
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
        val bonusLottoNumber = getBonusNumber(winningLotto)
        resultView.printEnter()

        resultView.printResult()
        val collectCounts = lottoNumberMatcher.checkLotto(winningLotto, lottoBundle.lottoBundle, bonusLottoNumber)
        val collectBonusCount = lottoNumberMatcher.checkBonusLotto(winningLotto, lottoBundle.lottoBundle, bonusLottoNumber)

        val resultGroup = lottoNumberMatcher.lottoResultGroup(collectCounts)
        resultView.printWinningResult(resultGroup, collectBonusCount)

        val winningMoney = lottoMoneyMatcher.winningMoneyCheck(collectCounts, collectBonusCount)
        val returnRatio = rateCalculator.calculateRateOfReturn(lottoBundle.inputMoney, winningMoney)
        resultView.printRateOfReturn(returnRatio)
    }

    private fun getBonusNumber(lotto: Lotto): LottoNumber {
        val bonusNumber = inputView.inputBonusLottoNumber().toInt()
        return lottoBonusNumberValidation(bonusNumber, lotto)
    }

    private fun getWinningLotto(): Lotto {
        val lastWeekNumber = inputView.inputLottoNumberByLastWeek()
        val lottoNumbers = splitLottoNumbers(lastWeekNumber)
        return Lotto(numbers = lottoNumbers)
    }

    private fun getLottoBundleByMoney(): LottoBundle {
        val inputMoney = inputView.inputLottoBuyMoney().toInt()
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

    private fun lottoBonusNumberValidation(bonusNumber: Int, lotto: Lotto): LottoNumber {
        val lottoNumber = LottoNumber(bonusNumber)
        require(!lotto.numbers.contains(lottoNumber.number)) {
            "보너스 숫자가 중복이 될 수 없습니다."
        }
        return lottoNumber
    }
}

fun main() {
    LottoApplication(RateCalculator(), LottoNumberMatcher(), LottoMoneyMatcher()).startLottery()
}
