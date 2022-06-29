package lotto.entity

class LottoTicket(val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_LENGTH) { "로또 번호는 6자리여야 합니다." }
    }

    fun getWinningNumbersMatch(lottoNumber: LottoNumber): Int {
        return numbers.intersect(lottoNumber.getWinningNumbersSet()).count()
    }

    companion object {
        const val LOTTO_NUMBER_LENGTH = 6
        const val LOTTO_PRICE = 1000
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
    }
}
