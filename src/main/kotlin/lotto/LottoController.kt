package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.Reward
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun play() {
        val amount = getAmount()
        val lottoList = LottoMachine.getLottoList(amount)
        printLotto(lottoList)

        val winningLotto = getWinningLotto()
        val matchReward = LottoMachine.match(lottoList, winningLotto)
        printResult(matchReward)

        val incomeRate = LottoMachine.getIncomeRate(purchaseCount = lottoList.size, matchReward = matchReward)
        ResultView.printIncomeRate(incomeRate)
    }

    private fun printResult(matchReward: Map<Reward, Int>) {
        ResultView.printMessage(ResultView.Message.RESULT)
        ResultView.printDiv()

        matchReward.entries
            .sortedBy { (reward, _) -> reward.matchCount }
            .forEach { (reward, resultCount) ->
                ResultView.printResult(
                    matchCount = reward.matchCount,
                    price = reward.amount,
                    resultCount = resultCount
                )
            }
    }

    private fun getWinningLotto(): Lotto {
        ResultView.printMessage(ResultView.Message.REQUEST_LOTTO_NUMBERS)
        val numbers: List<Int> = InputView.requestPositiveNumbers()

        return LottoMachine.generateLotto(numbers)
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
    LottoController().play()
}
