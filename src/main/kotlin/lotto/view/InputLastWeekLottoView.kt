package lotto.view

import lotto.infra.port.IOSystem
import lotto.policy.BonusLotteryPolicy
import lotto.vo.LotteryNumber
import lotto.vo.LotteryNumberSet

class InputLastWeekLottoView(private val ioSystem: IOSystem) {

    fun getLastWeekLotto(): BonusLotteryPolicy {
        printInputLastWeekMessage()
        return inputLastWeekLotto()
    }

    private fun printInputLastWeekMessage() {
        ioSystem.write("지난 주 당첨 번호를 입력해 주세요.\n")
    }

    private fun inputLastWeekLotto() =
        BonusLotteryPolicy(convertToNumbers(ioSystem.read()), LotteryNumber.of(10))

    private fun convertToNumbers(inputLottoNumbers: String) =
        inputLottoNumbers
            .split(",")
            .map(String::trim)
            .map(String::toInt)
            .map(LotteryNumber::of)
            .let(::LotteryNumberSet)
}
