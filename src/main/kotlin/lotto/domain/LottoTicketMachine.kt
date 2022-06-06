package lotto.domain

object LottoTicketMachine {
    fun generate(number: Int): LottoTickets {
        require(number > 0) {
            "1개 이상 구매해야 합니다."
        }

        return LottoTickets(
            List(number) {
                generateTicket()
            }
        )
    }

    private fun generateTicket(): LottoTicket {
        return LottoTicket(
            LottoNumber.shuffled()
                .take(LottoTicket.LOTTO_SIZE)
                .sorted()
                .toSet()
        )
    }
}
