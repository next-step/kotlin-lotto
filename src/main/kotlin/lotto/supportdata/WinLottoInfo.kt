package lotto.supportdata

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

class WinLottoInfo(winNumberInput: String, bonusNumberInput: Int) {
    val winLottoTicket: LottoTicket = parseInputToLotto(winNumberInput)
    val bonusNumber: LottoNumber = LottoNumber(bonusNumberInput)

    init {
        require(bonusNumber !in winLottoTicket) { "보너스 숫자는 당첨 번호와 겹칠 수 업습니다" }
    }
}
