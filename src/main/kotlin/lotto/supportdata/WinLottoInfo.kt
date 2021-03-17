package lotto.supportdata

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

class WinLottoInfo(private val winNumberInput: String, private val bonusNumberInput: Int) {
    val winLottoTicket: LottoTicket = parseInputToLotto()
    val bonusNumber: LottoNumber = LottoNumber(bonusNumberInput)

    init {
        require(bonusNumber !in winLottoTicket) { "보너스 숫자는 당첨 번호와 겹칠 수 업습니다" }
    }

    private fun parseInputToLotto(): LottoTicket {
        val numbers = winNumberInput.split(DELIMITER)
            .mapNotNull { it.trim().toIntOrNull() }
        return LottoTicket.of(numbers)
    }

    companion object {
        const val DELIMITER = ","
    }
}
