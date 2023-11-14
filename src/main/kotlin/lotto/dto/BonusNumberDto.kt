package lotto.dto

import lotto.domain.LottoNumber

data class BonusNumberDto(private val bonusNumber: Int) {
    val lottoNumber: LottoNumber = LottoNumber(bonusNumber)
}
