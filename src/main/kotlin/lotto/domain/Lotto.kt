package lotto.domain

class Lotto(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBERS_SIZE) { "로또 번호는 6개여야 합니다." }
    }

    constructor(numbers: List<Int>) : this(numbers.map { LottoNumber.from(it) }.toSet())

    val size: Int
        get() = numbers.size

    fun countMatch(lotto: Lotto): Int {
        return numbers
            .intersect(lotto.numbers)
            .size
    }

    fun match(lottoNumber: LottoNumber): Boolean {
        return numbers.contains(lottoNumber)
    }

    override fun toString(): String {
        return numbers.joinToString(
            prefix = "[",
            postfix = "]",
            separator = ", ",
        )
    }

    companion object {
        const val LOTTO_NUMBERS_SIZE = 6
    }
}
