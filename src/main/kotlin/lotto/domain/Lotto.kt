package lotto.domain

class Lotto(
    val lottoNumbers: Set<LottoNumber>
) {

    init {
        require(lottoNumbers.size == 6) { "로또는 6개 숫자로 구성됩니다." }
    }

    fun matchLottoNumber(matchingNumber: List<LottoNumber>): LottoRank {
        val matchedCount = lottoNumbers.count { matchingNumber.contains(it) }
        return LottoRank.getByMatchCount(matchedCount)
    }

    companion object {
        fun of(lottoNumbers: List<Int>): Lotto {
            return Lotto(lottoNumbers.map { LottoNumber(it) }.toSet())
        }

        const val LOTTO_PRICE = 1_000
    }
}
