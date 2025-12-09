package lotto.input

import lotto.LottoMessageConst.Companion.ERROR_MESSAGE_EMPTY
import lotto.LottoMessageConst.Companion.ERROR_MESSAGE_LOTTO_NUMBER_INVALID
import lotto.domain.Lotto
import lotto.domain.LottoNumber

class WinLottoInputView {
    companion object {
        fun process(winLotto: String?): Lotto {
            return parseAndValidate(winLotto)
        }

        fun process(): Lotto {
            while (true) {
                try {
                    println("지난 주 당첨 번호를 입력해 주세요.")
                    return process(readln())
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }

        private fun parseAndValidate(winLotto: String?): Lotto {
            requireNotNull(winLotto) { ERROR_MESSAGE_EMPTY }
            require(winLotto.isNotBlank()) { ERROR_MESSAGE_EMPTY }

            val trimmed = winLotto.trim()
            validateOnlyDigits(trimmed)

            val numbers = parseLottoNumbers(trimmed)
            return Lotto(numbers)
        }

        private fun validateOnlyDigits(input: String) {
            val withoutSpaces = input.replace(" ", "")
            require(withoutSpaces.all { it.isDigit() }) {
                ERROR_MESSAGE_LOTTO_NUMBER_INVALID
            }
        }

        private fun parseLottoNumbers(input: String): List<LottoNumber> {
            return input
                .split(" ")
                .filter { it.isNotBlank() }
                .map { it.toInt() }
                .map { LottoNumber(it) }
        }
    }
}
