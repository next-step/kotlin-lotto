package lotto.domain

private const val LOTTO_LENGTH = 6

class Lotto(
    private val lottoNumbers: List<LottoNumber>
) {
    init {
        val distinctLottoNumbers = lottoNumbers.distinct()
        require(lottoNumbers.size == LOTTO_LENGTH) { "로또는 6개의 로또 숫자를 가져야합니다." }
        require(distinctLottoNumbers.size == LOTTO_LENGTH) { "중복되는 로또 숫자를 가질 수 없습니다." }
    }

    fun countSameLottoNumbers(other: Lotto): Int = lottoNumbers.count { lottoNumber -> other.contains(lottoNumber) }

    private fun contains(lottoNumber: LottoNumber) = lottoNumbers.any { it == lottoNumber }
}

private const val MIN_LOTTO_NUMBER = 1
private const val MAX_LOTTO_NUMBER = 45

@JvmInline
value class LottoNumber(
    private val value: Int,
) {
    init {
        require(value in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { "로또 숫자를 1 ~ 45 사이의 숫자만 허용됩니다." }
    }
}
