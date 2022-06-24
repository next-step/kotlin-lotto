package lotto.domain

class Lotto(
    lottoNumbers: Set<LottoNumber>,
) {
    val lottoNumbers: Set<LottoNumber>

    init {
        require(lottoNumbers.size == LOTTO_LENGTH) { "로또는 6개의 로또 숫자를 가져야합니다." }
        this.lottoNumbers = lottoNumbers.toSortedSet(compareBy(LottoNumber::value))
    }

    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber.valueOf(it) }.toSet())

    fun countSameLottoNumbers(other: Lotto): Int =
        lottoNumbers.count { lottoNumber -> other.containsLottoNumber(lottoNumber) }

    fun containsLottoNumber(lottoNumber: LottoNumber) = lottoNumbers.contains(lottoNumber)

    companion object {
        const val PRICE = 1_000
        const val LOTTO_LENGTH = 6
    }
}
