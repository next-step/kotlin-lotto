package lotto

@JvmInline
value class Lotto(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == SIZE)
    }

    fun contains(number: LottoNumber): Boolean {
        return numbers.contains(number)
    }

    companion object {
        const val SIZE = 6
    }
}
