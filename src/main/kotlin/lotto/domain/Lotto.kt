package lotto.domain

class Lotto(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == 6) { ERROR_LOTTO_NUMBER_COUNT }
    }

    fun countMatches(lotto: Lotto): Int = numbers.count { lotto.contains(it) }

    operator fun contains(lottoNumbers: LottoNumber): Boolean = numbers.contains(lottoNumbers)

    companion object {
        private const val ERROR_LOTTO_NUMBER_COUNT = "로또는 랜덤한 6개의 숫자를 가져야 한다."

        fun of(numbers: Set<Int>): Lotto = Lotto(numbers.map { LottoNumber(it) }.toSet())
    }
}
