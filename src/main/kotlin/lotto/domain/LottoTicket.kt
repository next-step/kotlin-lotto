package lotto.domain

class LottoTicket(val numbers: Set<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) {
            "6자리 로또 티켓을 입력해주세요."
        }
    }

    fun isMatch(matchCount: Int, winningNumber: Set<Int>): Boolean {
        return numbers.intersect(winningNumber).size == matchCount
    }

    companion object {
        private const val LOTTO_SIZE = 6
    }
}
