package lotto.domain

data class WinningLotto(
    val lottoNumbers: LottoNumbers,
    val bonus: LottoNumber,
) {
    init {
        require(bonus !in lottoNumbers) { "보너스 볼 번호는 로또 번호와 중복될 수 없습니다" }
    }

    fun countMatchedNumber(other: Lotto): Int {
        return lottoNumbers.countMatchedNumber(other.lottoNumbers)
    }

    fun matchBonus(other: Lotto): Boolean {
        return bonus in other.lottoNumbers
    }

    companion object {
        fun create(
            lottoNumbers: LottoNumbers,
            bonus: Int,
        ): WinningLotto {
            return WinningLotto(
                lottoNumbers = lottoNumbers,
                bonus = LottoNumber(bonus),
            )
        }
    }
}
