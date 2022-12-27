package lotto.domain

class Lotto(
    val lottoNumbers: List<LottoNumber>
) {
    init {
        require(lottoNumbers.size == LOTTO_NUMBERS_SIZE) { "로또 번호는 ${LOTTO_NUMBERS_SIZE}개가 필요합니다." }
        require(lottoNumbers.toSet().size == LOTTO_NUMBERS_SIZE) { "번호에 중복이 있습니다." }
    }

    fun countHitNumbers(luckyLotto: Lotto): Int {
        val count = lottoNumbers.count { luckyLotto.lottoNumbers.contains(it) }
        return count
    }

    fun hasBonusNumber(bonusNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(bonusNumber)
    }

    companion object {
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
        const val LOTTO_NUMBERS_SIZE = 6
    }
}
