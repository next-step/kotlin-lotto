package lotto

import lotto.domain.BoughtMoney

class LottoGame {
    fun parseInputMoney(input: String?): BoughtMoney =
        try {
            requireNotNull(input) { "구입 금액은 필수입니다." }
            BoughtMoney(input.toInt())
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("구입 금액은 숫자만 입력가능합니다.")
        }
}