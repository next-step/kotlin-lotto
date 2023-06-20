package lotto.domain.lottonumber

import math.PositiveNumber

data class WinLottoNumbers(
    val lottoNumbers: LottoNumbers,
    val bonusNumber: LottoNumber,
) {


    init {
        require(bonusNumber !in lottoNumbers) {
            "bonus number can not be duplicated with lotto numbers"
        }
    }

    fun matchCount(other: LottoNumbers): PositiveNumber {
        return lottoNumbers.matchCount(other)
    }

    fun matchBonus(other: LottoNumbers): Boolean {
        return bonusNumber in other
    }
}
