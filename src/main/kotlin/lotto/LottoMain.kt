package lotto

import lotto.domain.Lottery
import lotto.domain.LotteryGroup
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.view.InputView
import lotto.view.ResultView

const val EMPTY_SIZE = 0
const val WIN_LOTTERY_POSITION = 0
const val DEFAULT_COUNT = 1

fun main() {

    val amount = getInputDataInteger("구입금액을")
    val buyCount = getInputDataInteger("수동으로 구매할 로또 수를")
    val lotteriesByHand = getInputLotteryGroup("수동으로 구매할 번호 ${buyCount}개", buyCount)

    val lotteryByMachine = LottoMachine.buyLottery(amount, lotteriesByHand) ?: return
    ResultView.showBuyResult(lotteriesByHand, lotteryByMachine)

    val winLottery = getWinLottery()
    val bonusBall = getBonusBall()

    LottoMachine.setWinLotto(winLottery, bonusBall)

    val ranking = LottoMachine.generateRanking()
    ResultView.showGameResult(ranking)
}

private fun getBonusBall(): LottoNumber {
    var bonusBall: LottoNumber? = null
    do {
        bonusBall = getInputBonusBall()
    } while (bonusBall == null)
    return bonusBall
}

private fun getInputBonusBall(): LottoNumber? {
    var bonusNumber: LottoNumber? = null
    val data = getInputDataInteger("보너스 볼을")
    runCatching {
        bonusNumber = LottoNumber(data)
    }.getOrElse {
        it.printStackTrace()
    }
    return bonusNumber
}

private fun getInputDataInteger(message: String): Int {
    var buyCount: Int
    do {
        buyCount = InputView.getInputDataInteger(message)
    } while (buyCount == -1)
    return buyCount
}

private fun getWinLottery(): Lottery {
    return getInputLotteryGroup("지난 주 당첨 번호").lotteries[WIN_LOTTERY_POSITION]
}

private fun getInputLotteryGroup(message: String, count: Int = DEFAULT_COUNT): LotteryGroup {
    var lotteriesByHand = LotteryGroup()
    if (count > EMPTY_SIZE) {
        do {
            lotteriesByHand = InputView.getLotteriesByHand(message, count)
        } while (lotteriesByHand.lotteries.isEmpty())
    }
    return lotteriesByHand
}
