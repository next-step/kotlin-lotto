package lotto.domain

class LottoNumbers(
    val lottoNumbers: Set<LottoNumber>
) {
    init {
        require(lottoNumbers.size == LOTTO_SIZE) { "로또 번호는 중복 없는 6개 숫자로 구성되어야 해요" }
    }

    constructor(numbers: List<Int>) : this(
        numbers.map(LottoNumber::from).toSet()
    )

    companion object {
        const val LOTTO_SIZE = 6

        fun toInts(lottoNumbers: LottoNumbers): List<Int> {
            return lottoNumbers.lottoNumbers.map(LottoNumber::of)
        }
    }
}
