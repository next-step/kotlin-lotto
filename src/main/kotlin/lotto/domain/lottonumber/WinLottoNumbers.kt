package lotto.domain.lottonumber

data class WinLottoNumbers(
    val lottoNumbers: LottoNumbers,
    val bonusNumber: LottoNumber,
) {

    init {
        require(bonusNumber !in lottoNumbers) {
            "bonus number can not be duplicated with lotto numbers"
        }
    }

    fun matchCount(other: LottoNumbers): Int {
        return lottoNumbers.matchCount(other)
    }

    fun matchBonus(other: LottoNumbers): Boolean {
        return bonusNumber in other
    }
}
