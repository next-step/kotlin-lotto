package lotto

import lotto.domain.Cash
import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.Rank
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

        val rank = winner.match(lottoList)
        printResult(rank)

        val incomeRate = rank.getIncomeRate(purchaseCount = lottoList.size)
        ResultView.printIncomeRate(incomeRate)
    }

    private fun buyLotto(): List<Lotto> {
        val cash = inputCash()
        val (purchaseCount, changes) = payManualLotto(cash)
        val manualLottoList = getManualLottoList(purchaseCount)
        val lottoList = lottoStore.buyLotto(changes)
        printLotto(manualLottoList, lottoList)

        return lottoList
    }

    private fun printResult(rank: Rank) {
        ResultView.printMessage(ResultView.Message.RESULT)
        ResultView.printDiv()

        rank.matchReward
            .entries
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

    private fun printLotto(manualLottoList: List<Lotto>, lottoList: List<Lotto>) {
        ResultView.printPurchasedLottoCount(manualLottoList.size, lottoList.size)

        val totalLottoList = manualLottoList.plus(lottoList)

        totalLottoList.forEach { lotto ->
            val rawLottoNumbers = lotto.lottoNumbers
                .map { it.number }
                .sorted()

            ResultView.printLotto(rawLottoNumbers)
        }
    }

    private fun getManualLottoList(purchasesCount: Int): List<Lotto> {
        ResultView.printMessage(ResultView.Message.REQUEST_MANUAL_LOTTO_NUMBERS)

        return (1..purchasesCount).map {
            val numbers: List<Int> = InputView.requestPositiveNumbers()
            LottoMachine.generateLotto(numbers)
        }
    }

    private fun payManualLotto(cash: Cash): Pair<Int, Cash> {
        ResultView.printMessage(ResultView.Message.NUMBER_OF_MANUAL_PURCHASES)
        val purchasesCount = InputView.requestPositiveNumber()

        return LottoMachine.pay(cash, purchasesCount)
    }

    private fun inputCash(): Cash {
        ResultView.printMessage(ResultView.Message.REQUEST_AMOUNT)
        val amount = InputView.requestPositiveNumber()

        return Cash(amount)
    }
}

fun main() {
    LottoController(LottoMachine).play()
}
