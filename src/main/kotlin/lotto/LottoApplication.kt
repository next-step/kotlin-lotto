package lotto

import lotto.domain.Lotto
import lotto.domain.LottoBundle
import lotto.domain.LottoNumber
import lotto.utils.RateCalculator
import lotto.utils.StringUtils
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
        val manualLottoCount = inputView.inputBuyManualLottoCount().toInt()
        val manualLottoNumbers = getManualLottoNumbers(manualLottoCount)


        resultView.printLottoCount(inputMoney, manualLottoCount)

        val lottoManager = LottoManager()

        val lottoBundle = lottoManager.buyLotto(inputMoney, manualLottoNumbers)
        resultView.printLottoBundle(lottoBundle)
        resultView.printEnter()
        return LottoBundle(inputMoney, lottoBundle)
    }

    private fun getManualLottoNumbers(manualLottoCount: Int): List<Lotto> {
        val inputManualLottoNumbers = inputView.inputManualLottoNumbersByCount(manualLottoCount)

        val manualLottoNumbers = inputManualLottoNumbers.map {
            val target = StringUtils.replaceWhiteSpaceAndSplitByComma(it)
            Lotto(StringUtils.convertStringToInt(target))
        }
        return manualLottoNumbers
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
