package lotto.view

import lotto.EMPTY_SIZE
import lotto.InputParser
import lotto.domain.Lottery
import lotto.domain.LotteryGroup
import lotto.domain.LottoNumber

object InputView {

    private const val DEFAULT_COUNT = 1
    private const val WIN_LOTTERY_POSITION = 0

    private fun getInputDataInteger(message: String): Int {
        var buyCount: Int?
        do {
            println(message)
            val inputData = readlnOrNull()
            buyCount = InputParser.parseInputStringToInt(inputData)
        } while (buyCount == null)
        println()
        return buyCount
    }

    fun getInputLotteryGroup(count: Int = DEFAULT_COUNT): LotteryGroup {
        return innputLotteryGroup("수동으로 구매할 번호 ${count}개를 입력해 주세요.", count)
    }

    private fun innputLotteryGroup(message: String, count: Int = DEFAULT_COUNT): LotteryGroup {
        var lotteriesByHand: LotteryGroup?
        if (count == EMPTY_SIZE) {
            return LotteryGroup()
        }
        do {
            println(message)
            lotteriesByHand = lotteryGroup(count)
        } while (lotteriesByHand == null)
        println()
        return lotteriesByHand
    }

    fun getWinLotteryGroup(): Lottery {
        return innputLotteryGroup("지난 주 당첨 번호를 입력해 주세요.").lotteries[WIN_LOTTERY_POSITION]
    }

    fun getInputBonusBall(): LottoNumber {
        var bonusBall: LottoNumber?
        do {
            bonusBall = inputBonusNumber()
        } while (bonusBall == null)
        return bonusBall
    }

    private fun inputBonusNumber(): LottoNumber? {
        var bonusNumber: LottoNumber? = null
        val data = getInputDataInteger("보너스 볼을 입력해 주세요.")
        runCatching {
            bonusNumber = LottoNumber(data)
        }.getOrElse {
            it.printStackTrace()
        }
        return bonusNumber
    }

    private fun lotteryGroup(count: Int): LotteryGroup? {
        return runCatching {
            getLotteries(count)
        }.getOrElse {
            it.printStackTrace()
            return null
        }
    }

    private fun getLotteries(count: Int): LotteryGroup {
        val lotteries = mutableListOf<Lottery>()
        repeat(count) {
            val inputData = readlnOrNull() ?: ""
            val lottery = InputParser.parseLotteryNumbers(inputData)
            lotteries.add(Lottery(lottery))
        }
        return LotteryGroup(lotteries)
    }

    fun getInputBuyAmount(): Int {
        return getInputDataInteger("구입금액을 입력해 주세요.")
    }

    fun getInputBuyHandCount(): Int {
        return getInputDataInteger("수동으로 구매할 로또 수를 입력해 주세요.")
    }
}
