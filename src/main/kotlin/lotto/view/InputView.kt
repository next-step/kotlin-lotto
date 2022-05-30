package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.Money

object InputView {
    private const val NULL_MESSAGE = "입력값은 null일 수 없습니다."

    fun getMoney(): Money {
        println("구입 금액을 입력해 주세요.")

        val money = readLine()?.toInt()

        requireNotNull(money) { NULL_MESSAGE }

        return Money(money)
    }

    fun getWinningNumbers(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val winningValue = readLine()
            ?.replace(" ", "")
            ?.split(",")
            ?.mapNotNull { it.toIntOrNull() }
            ?.map { LottoNumber(it) }

        requireNotNull(winningValue) { NULL_MESSAGE }

        return winningValue
    }

    fun getBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readLine()?.toInt()

        requireNotNull(bonusNumber) { NULL_MESSAGE }

        return LottoNumber(bonusNumber)
    }
}
