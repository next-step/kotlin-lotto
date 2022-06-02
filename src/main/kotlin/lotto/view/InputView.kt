package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber

class InputView {
    fun getMoney(): Int {
        println(INPUT_MONEY)
        return readln().toInt()
    }

    fun getPastWinner(): Lotto {
        println(INPUT_LAST_WINNER)
        val numbers = readln()
            .split(LOTTO_SPLIT_DELIMITER)
            .map { it.toInt() }
            .toSet()
        return Lotto.of(numbers)
    }

    fun getBonusNumber(): LottoNumber {
        println(INPUT_BONUS_NUMBER)
        return LottoNumber(readln().toInt())
    }

    companion object {
        private const val INPUT_MONEY = "구입금액을 입력해 주세요."
        private const val INPUT_LAST_WINNER = "지난 주 당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요."

        private const val LOTTO_SPLIT_DELIMITER = ","
    }
}
