package lotto.domain

data class Lotto(val numbers: Set<LottoNumber>) {

    init {
        require(numbers.size == LOTTO_COUNT) { "로또는 서로 다른 ${LOTTO_COUNT}개의 숫자로 구성되어야 합니다." }
    }

    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber.from(it) }.toSet())
    constructor(numbers: List<Int>) : this(numbers.map { LottoNumber.from(it) }.toSet())

    fun contains(number: Int): Boolean {
        return numbers.any { it.value == number }
    }

    companion object {
        const val LOTTO_COUNT = 6
    }
}
