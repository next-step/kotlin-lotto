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
}

@JvmInline
value class LottoNumber(
    private val value: Int,
) {
    init {
        require(value in 1..45) { "로또 숫자를 1 ~ 45 사이의 숫자만 허용됩니다." }
    }
}
