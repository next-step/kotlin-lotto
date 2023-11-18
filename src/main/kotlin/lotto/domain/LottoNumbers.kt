package lotto.domain

@JvmInline
value class LottoNumbers(val value: Set<LottoNumber>) {
    init {
        validateSize()
    }

    fun match(other: LottoNumbers): Int =
        value.count { it in other }

    private fun validateSize() {
        require(value.size == LOTTO_NUMBER_SIZE) { "로또에 적힌 숫자는 6개입니다" }
    }

    operator fun contains(lottoNumber: LottoNumber): Boolean = value.contains(lottoNumber)

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_NUMBER_SIZE = 6
    }
}
