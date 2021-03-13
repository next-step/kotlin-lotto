package lotto.domain

class LottoStore {
    fun purchase(amount: String): List<LottoTicket> {
        val count = amount.toInt() / LOTTO_PRICE
        return mutableListOf<LottoTicket>().also { tickets -> repeat(count) { tickets.add(LottoTicket.create()) } }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
