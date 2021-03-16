package lotto.supportdata

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

class WinLottoInfo(private val winNumberInput: String, private val bonusNumberInput: Int) {
    val winLottoTicket: LottoTicket = parseInputToLotto()
    val bonusNumber: LottoNumber = LottoNumber(bonusNumberInput)

    private fun parseInputToLotto(): LottoTicket {
        val numbers = winNumberInput.split(DELIMITER)
            .mapNotNull { it.trim().toIntOrNull() }
        return LottoTicket.of(numbers)
    }

    companion object {
        const val DELIMITER = ","
    }
}
