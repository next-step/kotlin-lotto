package lotto.domain

data class LottoNumbers(private val numbers: Set<LottoNumber>) {
    constructor(vararg numbers: Int) : this(numbers.map { number -> LottoNumber.of(number) }.toSet())
    init {
        require(numbers.size == 6) { INVALID_LOTTO_NUMBER_COUNT_MESSAGE }
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return numbers.contains(lottoNumber)
    }

    override fun toString(): String {
        return numbers.joinToString(", ") { it.number.toString() }
    }

    companion object {
        const val INVALID_LOTTO_NUMBER_COUNT_MESSAGE: String = "로또 번호는 6개여야 합니다"
    }
}
