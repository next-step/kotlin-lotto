package lotto.view.input

import lotto.domain.LottoNumber

data class BonusInput(val input: String?) {
    val bonusNumber: LottoNumber

    init {
        require(!input.isNullOrBlank()) { "보너스 번호는 필수입니다." }

        val number = input.toIntOrNull() ?: throw IllegalArgumentException("보너스 번호는 숫자여야 합니다.")

        bonusNumber = LottoNumber.from(number)
    }
}
