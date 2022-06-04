package lotto.view

import lotto.model.LottoNumber
import lotto.model.LottoNumbers

class InputView {

    fun getBuyingPrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputLastWinningNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
            .split(DEFAULT_DELIMITER)
            .map { it.trim() }
            .map { LottoNumber.from(it.toInt()) }
            .let(::LottoNumbers)
    }

    companion object {
        private const val DEFAULT_DELIMITER = ","
    }
}
