package lotto.domain.lottonumber

import math.PositiveNumber

data class WinLottoNumbers(
    val lottoNumbers: LottoNumbers,
    val bonusNumber: LottoNumber,
) {

    private val lottoNumberSet by lazy { lottoNumbers.toSet() }

    init {
        require(bonusNumber !in lottoNumbers) {
            "bonus number can not be duplicated with lotto numbers"
        }
    }

    fun matchCount(other: LottoNumbers): PositiveNumber {
        val matchCount = other.value.count { lottoNumberSet.contains(it) }
        return PositiveNumber(matchCount)
    }

    fun matchBonus(other: LottoNumbers): Boolean {
        return bonusNumber in other
    }
}
