package lotto.domain

class LottoTicketSeller {
    fun buyLottoTickets(money: Money): LottoTickets {
        val lottoTickets = mutableListOf<LottoTicket>()
        repeat(money.divideInt(LottoTicket.PRICE)) { lottoTickets.add(issueLottoTicket()) }
        return LottoTickets(values = lottoTickets)
    }

    private fun issueLottoTicket(): LottoTicket {
        val lottoNumbers = LottoNumber.cachedLottoNumbers()
            .asSequence()
            .shuffled()
            .take(LottoNumbers.NUMBERS_COUNT + BONUS_NUMBER_COUNT)
            .toMutableList()

        return LottoTicket(
            bonusNumber = lottoNumbers.removeFirst(),
            lottoNumbers = LottoNumbers.createWithSort(lottoNumbers.toSet()),
        )
    }

    companion object {
        private const val BONUS_NUMBER_COUNT = 1
    }
}
