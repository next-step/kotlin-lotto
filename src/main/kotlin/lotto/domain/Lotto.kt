package lotto.domain

data class Lotto(
    val numbers: List<LottoNumber>,
    val type: LottoType,
) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "로또 번호는 ${LOTTO_NUMBER_SIZE}개만 입력할 수 있습니다. [${numbers.size}]" }
        require(numbers.distinct().size == LOTTO_NUMBER_SIZE) { "로또 번호는 중복될 수 없습니다. [$numbers]" }
    }

    fun match(lotto: Lotto): Int {
        return numbers.intersect(lotto.numbers).size
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return numbers.contains(lottoNumber)
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6

        fun of(numbers: List<Int>, type: LottoType): Lotto {
            return Lotto(numbers.map { LottoNumber(it) }, type)
        }
    }
}
