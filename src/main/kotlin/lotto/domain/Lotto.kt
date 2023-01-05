package lotto.domain

class Lotto(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBERS_COUNT) { "fail lotto number count" }
    }

    fun contains(number: LottoNumber): Boolean = numbers.contains(number)

    override fun toString(): String = numbers.map { it.number }.toString()

    companion object {
        const val LOTTO_NUMBERS_COUNT = 6
    }
}
