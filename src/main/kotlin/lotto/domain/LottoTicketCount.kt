package lotto.domain

class LottoTicketCount(val value: Int) {

    init {
        require(value >= 0) { "티켓 갯수는 0 이상의 정수입니다" }
    }

    fun isTicketRemain(): Boolean {
        return value > 0
    }

    fun useTicket(): LottoTicketCount {
        check(isTicketRemain()) { "티켓을 모두 사용했습니다" }

        return LottoTicketCount(value - 1)
    }
}
