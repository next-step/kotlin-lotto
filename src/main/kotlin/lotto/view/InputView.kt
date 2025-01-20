package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber

class InputView {
    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val input = readlnOrNull()?.toIntOrNull()
        requireNotNull(input)
        return input
    }

    fun inputWinningNumbers(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers: List<Int> = readlnOrNull()?.split(",")
            ?.map {
                it.trim()
                    .toInt()
            } ?: emptyList()
        return Lotto(*winningNumbers.toIntArray())
    }

    fun inputBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber(readlnOrNull()?.toIntOrNull() ?: 0)
    }
}
