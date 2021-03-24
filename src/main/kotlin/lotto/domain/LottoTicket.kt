package lotto.domain

class LottoTicket(private val numbers: Set<LottoNumber>) : Set<LottoNumber> by numbers {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 6개가 있어야 합니다" }
    }

    constructor(generator: LottoNumberGenerator = LottoNumberRandomGenerator()) : this(generator.pickNumber())

    override fun toString(): String {
        return numbers.joinToString(prefix = "[", postfix = "]")
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
