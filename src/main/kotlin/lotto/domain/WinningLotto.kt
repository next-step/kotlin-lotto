package lotto.domain

data class WinningLotto(
    val lottoNumbers: LottoNumbers,
    val bonus: LottoNumber,
) {
    init {
        require(!lottoNumbers.containsNumber(bonus)) { "보너스 볼 번호는 로또 번호와 중복될 수 없습니다" }
    }

    fun countMatchedNumber(other: Lotto): Int {
        return lottoNumbers.countMatchedNumber(other.lottoNumbers)
    }

    companion object {
        fun create(
            numbers: Set<Int>,
            bonus: Int,
        ): WinningLotto {
            return WinningLotto(
                lottoNumbers = LottoNumbers.from(numbers),
                bonus = LottoNumber(bonus)
            )
        }
    }
}
