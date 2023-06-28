package lotto.domain

class LottoNumbers(
    val lottoNumbers: Set<LottoNumber>,
) {
    init {
        require(lottoNumbers.size == 6) { "로또는 6개 숫자로 구성됩니다." }
    }

    fun matchNumbers(matchNumbers: LottoMatchNumbers): LottoMatchCount {
        return matchNumbers.match(lottoNumbers.toList())
    }

    companion object {
        fun of(lottoNumbers: List<Int>): LottoNumbers {
            return LottoNumbers(lottoNumbers.map { LottoNumber(it) }.toSet())
        }
    }
}
