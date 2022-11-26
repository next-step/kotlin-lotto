package lotto

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.Reward
import lotto.domain.Winner
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(private val lottoGenerator: LottoGenerator) {
    private val lottoStore = LottoStore(lottoGenerator)

    fun play() {
        val lottoList = buyLotto()
        checkWinningLotto(lottoList)
    }

    private fun checkWinningLotto(lottoList: List<Lotto>) {
        val winningLotto = getWinningLotto()
        val bonusLottoNumber = getBonusLottoNumber()
        val winner = Winner(winningLotto, bonusLottoNumber)

        val matchReward = winner.match(lottoList)
        printResult(matchReward)

        val incomeRate = winner.getIncomeRate(purchaseCount = lottoList.size, matchReward = matchReward)
        ResultView.printIncomeRate(incomeRate)
    }

    private fun buyLotto(): List<Lotto> {
        val amount = getAmount()
        val lottoList = lottoStore.buyLotto(amount)
        printLotto(lottoList)

        return lottoList
    }

    private fun printResult(matchReward: Map<Reward, Int>) {
        ResultView.printMessage(ResultView.Message.RESULT)
        ResultView.printDiv()

        matchReward.entries
            .sortedBy { (reward, _) -> reward.amount }
            .forEach { (reward, resultCount) ->
                ResultView.printResult(
                    matchCount = reward.matchCount,
                    price = reward.amount,
                    matchBonus = reward.hasBonus,
                    resultCount = resultCount
                )
            }
    }

    private fun getBonusLottoNumber(): LottoNumber {
        ResultView.printMessage(ResultView.Message.REQUEST_BONUS_NUMBERS)
        val bonusNumber = InputView.requestPositiveNumber()

        return LottoNumber.from(bonusNumber)
    }

    private fun getWinningLotto(): Lotto {
        ResultView.printMessage(ResultView.Message.REQUEST_LOTTO_NUMBERS)
        val numbers: List<Int> = InputView.requestPositiveNumbers()

        return lottoGenerator.generateLotto(numbers)
    }

    private fun printLotto(lottoList: List<Lotto>) {
        ResultView.printMessage(lottoList.size.toString(), ResultView.Message.NUMBER_OF_PURCHASES)
        lottoList.forEach { lotto ->
            val rawLottoNumbers = lotto.lottoNumbers
                .map { it.number }
                .sorted()

            ResultView.printLotto(rawLottoNumbers)
        }
    }

    private fun getAmount(): Int {
        ResultView.printMessage(ResultView.Message.REQUEST_AMOUNT)
        return InputView.requestPositiveNumber()
    }
}

fun main() {
    LottoController(LottoMachine).play()
}
