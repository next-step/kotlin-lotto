package lotto.domain.numbers

class LottoNumbers(lottoNumbers: List<Int>) {
    val list: List<Int> = lottoNumbers
        .takeIf {
            lottoNumbers.size == LOTTO_NUMBER_SIZE &&
                lottoNumbers.filter { it in LOTTO_NUMBER_POOL }.size == LOTTO_NUMBER_SIZE
        } ?: throw IllegalArgumentException("로또 번호는 총 6개이고 1과 45사이의 숫자여야 합니다.")

    constructor() : this(LOTTO_NUMBER_POOL.shuffled().take(LOTTO_NUMBER_SIZE))

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private val LOTTO_NUMBER_POOL = (1..45)
    }
}
