package lotto

import lotto.domain.Cash
import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.Lottos
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

    private fun checkWinningLotto(lottos: Lottos) {
        val winningLotto = getWinningLotto()
        val bonusLottoNumber = getBonusLottoNumber()
        val winner = Winner(winningLotto, bonusLottoNumber)

        val rank = winner.match(lottos.lottoList)
        printResult(rank)

        val incomeRate = rank.getIncomeRate(purchaseCount = lottos.count)
        ResultView.printIncomeRate(incomeRate)
    }

    private fun buyLotto(): Lottos {
        val cash = inputCash()
        val (manualLottos, changes) = payManualLotto(cash)
        val (autoLottos, _) = lottoStore.pay(changes)
        printLotto(manualLottos, autoLottos)

        return autoLottos
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

    private fun printLotto(manualLottos: Lottos, autoLottos: Lottos) {
        ResultView.printPurchasedLottoCount(manualLottos.count, autoLottos.count)

        val totalLottoList = manualLottos.lottoList.plus(autoLottos.lottoList)

        totalLottoList.forEach { lotto ->
            val rawLottoNumbers = lotto.lottoNumbers
                .map { it.number }
                .sorted()

            ResultView.printLotto(rawLottoNumbers)
        }
    }

    private fun payManualLotto(cash: Cash): Pair<Lottos, Cash> {
        ResultView.printMessage(ResultView.Message.NUMBER_OF_MANUAL_PURCHASES)
        val purchasesCount = InputView.requestPositiveNumber()

        ResultView.printMessage(ResultView.Message.REQUEST_MANUAL_LOTTO_NUMBERS)
        val lottoNumbers: List<Set<LottoNumber>> = getLottoNumbers(purchasesCount)

        return lottoStore.pay(cash, lottoNumbers)
    }

    private fun getLottoNumbers(purchasesCount: Int): List<Set<LottoNumber>> =
        (1..purchasesCount).map {
            val numbers: List<Int> = InputView.requestPositiveNumbers()

            numbers.map { number -> LottoNumber.from(number) }
                .toSet()
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
