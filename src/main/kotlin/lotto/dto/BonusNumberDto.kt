package lotto.dto

import lotto.domain.LottoNumber

data class BonusNumberDto(private val number: Int) {
    val bonusNumber: LottoNumber = LottoNumber(number)
}
