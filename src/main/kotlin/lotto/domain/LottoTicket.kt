package lotto.domain

class LottoTicket(
    val numbers: Set<Int>
) : Set<Int> by numbers {

    init {
        require(numbers.size == LOTTO_NUMBER_SIZE_BOUND) {
            "로또 숫자는 6개여야만 해요."
        }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE_BOUND = 6
    }
}
