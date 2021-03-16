package lotto.supportdata

import lotto.domain.LottoTicket

class WinNumber(private val winNumberInput: String) {
    val winLottoTicket: LottoTicket = parseInputToLotto()

    private fun parseInputToLotto(): LottoTicket {
        val numbers = winNumberInput.split(DELIMITER)
            .mapNotNull { it.trim().toIntOrNull() }
        return LottoTicket.of(numbers)
    }

    companion object {
        const val DELIMITER = ","
    }
}
