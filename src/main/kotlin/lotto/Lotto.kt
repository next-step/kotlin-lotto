package lotto

private const val SIZE = 6

@JvmInline
value class Lotto(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == SIZE)
    }
}
