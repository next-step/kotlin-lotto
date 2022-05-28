package lotto.domain

data class LottoTicket(val numbers: Set<Int>) {
    init {
        require(numbers.size == 6) {
            "6자리 로또 티켓을 입력해주세요."
        }
    }
}
