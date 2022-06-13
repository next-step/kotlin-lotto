package lotto.domain

private const val LOTTO_LENGTH = 6

class Lotto(
    lottoNumbers: List<LottoNumber>,
) {
    val lottoNumbers: List<LottoNumber>

    init {
        val distinctLottoNumbers = lottoNumbers.distinct()
        require(lottoNumbers.size == LOTTO_LENGTH) { "로또는 6개의 로또 숫자를 가져야합니다." }
        require(distinctLottoNumbers.size == LOTTO_LENGTH) { "중복되는 로또 숫자를 가질 수 없습니다." }
        this.lottoNumbers = lottoNumbers.sortedBy { it.value }
    }

    fun countSameLottoNumbers(other: Lotto): Int = lottoNumbers.count { lottoNumber -> other.contains(lottoNumber) }

    private fun contains(lottoNumber: LottoNumber) = lottoNumbers.any { it == lottoNumber }
}
