package lotto.view.input

import lotto.domain.LottoNumber

data class BonusInput(val bonusNumber: LottoNumber) {

    constructor(input: String) : this(input.toInt())
    constructor(input: Int) : this(LottoNumber.from(input))

    companion object {
        private fun String.toInt(): Int {
            return this.toIntOrNull() ?: throw IllegalArgumentException("금액은 숫자야여 합니다.")
        }
    }
}
