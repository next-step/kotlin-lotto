package lotto.view

import lotto.infra.port.IOSystem
import lotto.policy.LotteryWithBonusPolicy
import lotto.vo.LotteryNumber
import lotto.vo.LotteryNumberSet

class InputLastWeekLottoView(private val ioSystem: IOSystem) {

    fun getLastWeekLotto() = LotteryWithBonusPolicy(inputLastWeekMessage(), inputBonusNumber())

    private fun inputLastWeekMessage(): LotteryNumberSet {
        ioSystem.write("지난 주 당첨 번호를 입력해 주세요.\n")
        return getLastWeekLotteryNumberSet()
    }

    private fun inputBonusNumber(): LotteryNumber {
        ioSystem.write("보너스 번호를 입력해 주세요.\n")
        return getBonusLotteryNumber()
    }

    private fun getLastWeekLotteryNumberSet() =
        ioSystem.read()
            .split(",")
            .map(String::trim)
            .map(String::toInt)
            .map(LotteryNumber::of)
            .let(::LotteryNumberSet)

    private fun getBonusLotteryNumber() =
        ioSystem.read()
            .trim()
            .let(String::toInt)
            .let(LotteryNumber::of)
}
