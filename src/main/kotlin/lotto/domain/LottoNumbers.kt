package lotto.domain

class LottoNumbers(val numbers: Set<LottoNumber>) {
    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber(it) }.toSet())
    constructor(numbers: List<Int>) : this(numbers.map { LottoNumber(it) }.toSet())

    fun countMatch(lottoNumbers: LottoNumbers): Int {
        return numbers
            .intersect(lottoNumbers.numbers)
            .size
    }

    fun match(number: Int): Boolean {
        return numbers.contains(LottoNumber(number))
    }

    val size: Int
        get() = numbers.size

    init {
        require(numbers.size == Lotto.LOTTO_NUMBER_SIZE) { "로또 번호는 6개여야 합니다." }
    }
}
