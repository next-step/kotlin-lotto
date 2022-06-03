package lotto.domain.numbers

class LottoNumbers(lottoNumbers: List<Int>) {
    val list: List<LottoNumber> = lottoNumbers
        .takeIf { lottoNumbers.size == LOTTO_NUMBER_SIZE }
        ?.map { LottoNumber.from(it) }
        ?: throw IllegalArgumentException("로또 번호는 총 6개이여야 합니다.")

    constructor() : this(LottoNumber.LOTTO_NUMBER_POOL.keys.shuffled().take(LOTTO_NUMBER_SIZE))

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
