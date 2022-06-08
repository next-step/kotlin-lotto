package lotto.domain

class Lotto(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == 6) { ERROR_LOTTO_NUMBER_COUNT }
    }

    fun countMatches(lotto: Lotto): Int = numbers.count { it in lotto }

    fun values(): List<Int> = numbers.map { it.number }

    fun count(): Int = numbers.size

    operator fun contains(lottoNumbers: LottoNumber): Boolean = lottoNumbers in numbers

    companion object {
        private const val ERROR_LOTTO_NUMBER_COUNT = "로또는 랜덤한 6개의 숫자를 가져야 한다."

        fun of(numbers: Set<Int>): Lotto = Lotto(numbers.map { LottoNumber(it) }.toSet())
    }
}
