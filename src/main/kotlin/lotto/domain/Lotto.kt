package lotto.domain

data class Lotto(
    val lottoNumbers: List<LottoNumber>
) {
    init {
        require(lottoNumbers.size == LOTTO_SIZE) { INVALID_LOTTO_SIZE_ERROR_MESSAGE(lottoNumbers.size) }
    }

    fun match(newLotto: Lotto): Int {
        return this.lottoNumbers.count(newLotto.lottoNumbers::contains)
    }

    companion object {
        const val LOTTO_SIZE = 6
        private val INVALID_LOTTO_SIZE_ERROR_MESSAGE =
            { lottoSize: Int -> "로또는 ${LOTTO_SIZE}개의 번호를 가져야 합니다. 현재 ${lottoSize}개 입니다." }

        fun of(inputNumbers: List<Int>): Lotto {
            return Lotto(inputNumbers.map { LottoNumber(it) })
        }
    }
}
