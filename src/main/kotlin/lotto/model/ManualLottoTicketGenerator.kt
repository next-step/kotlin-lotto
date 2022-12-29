package lotto.model

class ManualLottoTicketGenerator {
    fun generate(values: List<String>): List<LottoTicket> {
        val manualLottoTicket = mutableListOf<LottoTicket>()
        for (ticket in values) {
            manualLottoTicket.add(LottoTicket(splitNumber(ticket)))
        }
        return manualLottoTicket
    }

    private fun splitNumber(value: String): List<Int> {
        return value.split(NUMBER_DELIMITER).map { it.toInt() }
    }

    companion object {
        private const val NUMBER_DELIMITER = ", "
    }
}
