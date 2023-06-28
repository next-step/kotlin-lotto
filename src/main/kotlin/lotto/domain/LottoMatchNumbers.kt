package lotto.domain

class LottoMatchNumbers(
    val matchNumbers: Set<LottoNumber>,
    val bonusNumber: LottoNumber
) {

    init {
        require(matchNumbers.size == LOTTO_MATCH_NUMBERS_SIZE) { "당첨번호 수가 잘못되었습니다." }
    }

    fun match(lottoNumbers: List<LottoNumber>): LottoMatchCount {
        val matchCount = matchNumbers.intersect(lottoNumbers.toSet()).size
        val containsBonusNumber = lottoNumbers.contains(bonusNumber)

        return LottoMatchCount(matchCount = matchCount, containsBonusNumber = containsBonusNumber)
    }

    companion object {

        private const val LOTTO_MATCH_NUMBERS_SIZE = 7

        fun of(matchNumbers: List<Int>, bonusNumber: Int): LottoMatchNumbers {
            val lottoBonusNumber = LottoNumber(bonusNumber)
            return LottoMatchNumbers(
                matchNumbers = matchNumbers.map { LottoNumber(it) }.toSet() + lottoBonusNumber,
                bonusNumber = lottoBonusNumber
            )
        }
    }
}
