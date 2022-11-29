package lotto

private const val SIZE = 6

class WinningNumber(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == SIZE)
    }
}
