package lotto

class Lotto(
    private val numbers: List<Int>
) {

    fun getLotto(): List<Int> {
        lottoInputNumberValidation(numbers)
        return numbers.sorted()
    }

    private fun lottoInputNumberValidation(numbers: List<Int>) {
        require(numbers.size == COLLECT_LOTTO_SIZE) { "로또 입력 숫자는 총 6개여야 합니다" }
    }

    companion object {
        const val ONE_PRICE: Int = 1000
        const val NUMBER_COUNT: Int = 6
        private const val COLLECT_LOTTO_SIZE = 6
    }
}
