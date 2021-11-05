package lotto.domain

data class Lotto(val numbers: Set<LottoNumber>) {

    init {
        require(numbers.size == LOTTO_SIZE) { "로또 숫자의 갯수는 ${LOTTO_SIZE}여야 합니다. 현재 갯수 == ${numbers.size}" }
    }

    fun countMatchNumber(other: Lotto): Int {
        return numbers.filter { other.numbers.contains(it) }.count()
    }

    companion object {
        const val LOTTO_SIZE = 6

        fun of(lottoNumbers: List<LottoNumber>): Lotto {
            return Lotto(lottoNumbers.toSet())
        }
    }
}
