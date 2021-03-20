package lotto.supportdata

import lotto.domain.LottoTicket

const val DELIMITER = ","

fun parseInputToLotto(winNumberInput: String): LottoTicket {
    val numbers = winNumberInput.split(DELIMITER)
        .mapNotNull { it.trim().toIntOrNull() }
    return LottoTicket.of(numbers)
}
