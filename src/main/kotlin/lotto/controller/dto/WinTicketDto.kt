package lotto.controller.dto

import lotto.domain.LottoWinTicket

data class WinTicketDto(
    val winNumberString: String,
    val bonusString: String
) {
    fun toWinTicket(): LottoWinTicket {
        return LottoWinTicket.of(
            winNumberString,
            bonusString
        )
    }
}
