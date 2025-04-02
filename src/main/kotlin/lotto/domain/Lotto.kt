package lotto.domain

class Lotto(
    lottoNumbers: List<LottoNumber>,
) {
    private val numbers = lottoNumbers.sorted()

    val rawNumbers: List<Int>
        get() = numbers.map { it.value }

    init {
        require(numbers.size == LOTTO_SIZE) { "Lotto must contain exactly 6 numbers." }
    }

    constructor(vararg numbers: Int) : this(numbers.map(LottoNumber.Companion::from))

    fun compareMatches(lotto: Lotto) = numbers.count { it in lotto.numbers }

    fun contains(bonusNumber: LottoNumber) = numbers.contains(bonusNumber)

    companion object {
        private const val LOTTO_SIZE = 6
    }
}
