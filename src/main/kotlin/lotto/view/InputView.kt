package lotto.view

import lotto.domain.Lotto

class InputView {
    fun getMoney(): Int {
        println(INPUT_MONEY)
        return readln().toIntOrNull() ?: throw RuntimeException()
    }

    fun getPastWinner(): Lotto {
        println(INPUT_LAST_WINNER)
        val numbers = readln()
            .split(LOTTO_SPLIT_DELIMITER)
            .map { it.toIntOrNull() ?: throw RuntimeException(ERROR_WINNER_TICKET_VALIDATION) }
            .toSet()
        return Lotto.of(numbers)
    }

    companion object {
        private const val INPUT_MONEY = "구입금액을 입력해 주세요."
        private const val INPUT_LAST_WINNER = "지난 주 당첨 번호를 입력해 주세요."
        private const val ERROR_WINNER_TICKET_VALIDATION = "지난 주 당첨번호는 숫자여야 합니다."

        private const val LOTTO_SPLIT_DELIMITER = ","
    }
}
