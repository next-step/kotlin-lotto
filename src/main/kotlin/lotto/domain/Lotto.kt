package lotto.domain

class Lotto(val numbers: LottoNumbers) {
    constructor(numbers: List<Int>) : this(LottoNumbers(numbers.map { LottoNumber.from(it) }.toSet()))
    constructor(numbers: Set<Int>) : this(LottoNumbers(numbers.map { LottoNumber.from(it) }.toSet()))
    constructor(vararg numbers: Int) : this(LottoNumbers(numbers.map { LottoNumber.from(it) }.toSet()))

    override fun toString(): String {
        return numbers.numbers.joinToString(
            prefix = "[",
            postfix = "]",
            separator = ", ",
        )
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}
