package lotto

class Lotto(
    private val numbers: List<LottoNumber>,
) {
    init {
        require(numbers.size == LOTTO_SIZE) { "로또는 6개의 숫자를 가져야 합니다." }
    }

    val sortedNumbers: List<Int> = numbers.map(LottoNumber::value).sorted()

    fun match(winningNumbers: Set<LottoNumber>): Int {
        return numbers.count { it in winningNumbers }
    }

    companion object {
        private const val LOTTO_SIZE = 6
    }
}
