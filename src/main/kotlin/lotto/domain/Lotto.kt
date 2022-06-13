package lotto.domain

private const val LOTTO_LENGTH = 6

class Lotto(
    lottoNumbers: List<LottoNumber>,
) {
    val lottoNumbers: List<LottoNumber>

    init {
        val distinctLottoNumbers = lottoNumbers.toSet()
        require(lottoNumbers.size == LOTTO_LENGTH) { "로또는 6개의 로또 숫자를 가져야합니다." }
        require(distinctLottoNumbers.size == LOTTO_LENGTH) { "중복되는 로또 숫자를 가질 수 없습니다." }
        this.lottoNumbers = lottoNumbers.sortedBy { it.value }
    }

    constructor(
        firstLottoNumber: Int,
        secondLottoNumber: Int,
        thirdLottoNumber: Int,
        fourthLottoNumber: Int,
        fifthLottoNumber: Int,
        sixthLottoNumber: Int,
    ) : this(
        listOf(
            LottoNumber.valueOf(firstLottoNumber),
            LottoNumber.valueOf(secondLottoNumber),
            LottoNumber.valueOf(thirdLottoNumber),
            LottoNumber.valueOf(fourthLottoNumber),
            LottoNumber.valueOf(fifthLottoNumber),
            LottoNumber.valueOf(sixthLottoNumber),
        )
    )

    fun countSameLottoNumbers(other: Lotto): Int = lottoNumbers.count { lottoNumber -> other.containsLottoNumber(lottoNumber) }

    fun containsLottoNumber(lottoNumber: LottoNumber) = lottoNumbers.any { it == lottoNumber }

    companion object {
        const val PRICE = 1_000
    }
}
