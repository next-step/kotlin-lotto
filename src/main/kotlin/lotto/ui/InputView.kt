package lotto.ui

import lotto.domain.Amount
import lotto.domain.Count
import lotto.domain.Lotto
import lotto.domain.Lottos

object InputView {

    private const val INPUT_AMOUNT_NAME_MESSAGE = "구입금액을 입력해 주세요."
    private const val INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val INPUT_MANUAL_LOTTO_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요."
    private const val INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."
    private const val WINNING_NUMBERS_DELIMITER = ", "

    fun inputAmount(): Amount {
        println(INPUT_AMOUNT_NAME_MESSAGE)
        val amount = readln().toInt()
        return Amount(amount)
    }

    fun inputManualLottoCount(): Count {
        println()
        println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE)
        val count = readln().toInt()
        return Count(count)
    }

    fun inputManualLottoNumber(count: Count): Lottos {
        println()
        println(INPUT_MANUAL_LOTTO_NUMBER_MESSAGE)
        val lottos = List(count.count) {}
            .map {
                Lotto(readln()
                    .split(WINNING_NUMBERS_DELIMITER)
                    .map { it.toInt() })
            }
            .toList()
        return Lottos(lottos)
    }

    fun inputWinningNumbers(): List<Int> {
        println(INPUT_WINNING_NUMBERS_MESSAGE)
        return readln().split(WINNING_NUMBERS_DELIMITER).map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER_MESSAGE)
        return readln().toInt()
    }
}
