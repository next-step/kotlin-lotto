package lotto.domain

class Lotto(
    lottoNumbers: Set<LottoNumber>,
) {
    val lottoNumbers: Set<LottoNumber>

    init {
        require(lottoNumbers.size == LOTTO_LENGTH) { "로또는 6개의 로또 숫자를 가져야합니다." }
        this.lottoNumbers = lottoNumbers.toSortedSet(compareBy(LottoNumber::value))
    }

    fun countSameLottoNumbers(other: Lotto): Int =
        lottoNumbers.count { lottoNumber -> other.containsLottoNumber(lottoNumber) }

    fun containsLottoNumber(lottoNumber: LottoNumber) = lottoNumbers.contains(lottoNumber)

    companion object {
        const val PRICE = 1_000
        const val LOTTO_LENGTH = 6

        fun of(
            vararg numbers: Int,
        ): Lotto {
            val lottoNumbers = numbers.map { LottoNumber.valueOf(it) }.toSet()
            return Lotto(lottoNumbers)
        }
    }
}
