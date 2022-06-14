package lotto.entity

class LottoTicket(val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_LENGTH) { "로또 번호는 6자리여야 합니다." }
    }

    companion object {
        const val LOTTO_NUMBER_LENGTH = 6
        const val LOTTO_PRICE = 1000
    }
}
