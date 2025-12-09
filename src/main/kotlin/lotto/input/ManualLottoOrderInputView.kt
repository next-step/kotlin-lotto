package lotto.input

import lotto.LottoMessageConst.Companion.ERROR_MESSAGE_LOTTO_NUMBER_INVALID
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.ManualCount
import lotto.domain.ManualLottoOrder

class ManualLottoOrderInputView {
    companion object {
        fun process(
            manualCount: ManualCount,
            input: String?,
        ): ManualLottoOrder {
            return ManualLottoOrder(manualCount, parseAndValidate(input))
        }

        fun process(manualCount: ManualCount): ManualLottoOrder {
            while (true) {
                try {
                    val manualLottoNumbers =
                        if (manualCount.count > 0) {
                            println("수동으로 구매할 로또 번호를 입력해 주세요.")
                            (1..manualCount.count).joinToString("\n") { readln() }
                        } else {
                            null
                        }
                    return process(manualCount, manualLottoNumbers)
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }

        private fun parseAndValidate(manualLottoNumbers: String?): List<Lotto> {
            if (manualLottoNumbers == null || manualLottoNumbers.isBlank()) {
                return emptyList()
            }

            val lines = manualLottoNumbers.trim().split("\n")

            return lines.mapIndexed { index, line ->
                try {
                    val trimmed = line.trim()
                    validateOnlyDigits(trimmed)

                    val numbers =
                        line
                            .trim()
                            .split(" ")
                            .filter { it.isNotBlank() }
                            .map { it.toInt() }
                            .map { LottoNumber(it) }
                    Lotto(numbers)
                } catch (e: Exception) {
                    throw IllegalArgumentException("${index + 1}번째 줄: $ERROR_MESSAGE_LOTTO_NUMBER_INVALID", e)
                }
            }
        }

        private fun validateOnlyDigits(input: String) {
            val withoutSpaces = input.replace(" ", "")
            require(withoutSpaces.all { it.isDigit() }) {
                ERROR_MESSAGE_LOTTO_NUMBER_INVALID
            }
        }
    }
}
