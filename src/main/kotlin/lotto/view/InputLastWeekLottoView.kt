package lotto.view

import lotto.domain.LotteryNumberSet
import lotto.infra.port.IOSystem
import lotto.policy.LotteryWithBonusPolicy
import lotto.vo.LotteryNumber

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

    private fun getLastWeekLotteryNumberSet(): LotteryNumberSet =
        try {
            ioSystem.read()
                .split(",")
                .map(String::trim)
                .map(String::toInt)
                .map(LotteryNumber::of)
                .let(::LotteryNumberSet)
        } catch (exception: Exception) {
            ioSystem.write("잘못된 번호 목록을 입력하셨습니다. 다시 입력해주세요.")
            getLastWeekLotteryNumberSet()
        }

    private fun getBonusLotteryNumber(): LotteryNumber =
        try {
            ioSystem.read()
                .trim()
                .let(String::toInt)
                .let(LotteryNumber::of)
        } catch (exception: Exception) {
            ioSystem.write("잘못된 번호 입력하셨습니다. 다시 입력해주세요.")
            getBonusLotteryNumber()
        }
}
