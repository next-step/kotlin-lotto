package lotto

class Lotto(
    val numbers: List<Int>
) {
    init {
        require(numbers.size == COLLECT_LOTTO_SIZE) { "로또 입력 숫자는 총 6개여야 합니다" }
    }

    companion object {
        const val ONE_PRICE: Int = 1000
        const val COLLECT_LOTTO_SIZE = 6
    }
}
