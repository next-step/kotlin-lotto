package lotto.model

class ManualLottoTicketGenerator(private val values: List<String>) {
    val tickets: List<LottoTicket> = generate()

    private fun generate(): List<LottoTicket> {
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
