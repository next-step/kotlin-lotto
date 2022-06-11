package lotto.view

import lotto.model.Lotto
import lotto.model.LottoNumber

class InputView {

    fun getBuyingPrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputLastWinningNumbers(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
            .split(DEFAULT_DELIMITER)
            .map { it.trim() }
            .map { LottoNumber.from(it.toInt()) }
            .let(::Lotto)
    }

    fun inputBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber.from(readln().toInt())
    }

    companion object {
        private const val DEFAULT_DELIMITER = ","
    }
}
