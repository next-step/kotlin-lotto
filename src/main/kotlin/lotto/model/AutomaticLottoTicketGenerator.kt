package lotto.model

class AutomaticLottoTicketGenerator {
    fun generate(quantity: Int): List<LottoTicket> {
        return List(quantity) { LottoTicket((LOTTO_WINNER_NUMBER_RANGE).shuffled().take(6).sorted()) }
    }

    companion object {
        val LOTTO_WINNER_NUMBER_RANGE = 1..45
    }
}
