package lotto.domain

class Lotto(
    val lottoNumbers: List<LottoNumber>
) {

    fun matchLottoNumber(matchingNumber: List<LottoNumber>): LottoRank {
        val matchedCount = lottoNumbers.count { matchingNumber.contains(it) }
        return LottoRank.getByMatchCount(matchedCount)
    }

    companion object {
        fun of(lottoNumbers: List<Int>): Lotto {
            return Lotto(lottoNumbers.map { LottoNumber(it) })
        }

        const val LOTTO_PRICE = 1_000
    }
}
