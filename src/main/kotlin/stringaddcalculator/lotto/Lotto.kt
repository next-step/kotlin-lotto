package stringaddcalculator.lotto

class Lotto(
    private val numbers: Set<LottoNumber>
) {
    init {
        require(numbers.size == SIZE_OF_LOTTO_NUMBERS) { "로또 번호의 개수는 반드시 $SIZE_OF_LOTTO_NUMBERS 개이어야 합니다" }
    }

    companion object {
        private const val SIZE_OF_LOTTO_NUMBERS = 6
    }
}
