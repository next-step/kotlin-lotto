package lotto.domain.ticket

import lotto.domain.LottoNumber

data class WinningLottoCreator(
    val numbers: String,
    val bonusNumber: Int
) {
    fun toWinningLotto(): WinningLotto {
        val lottoNumbers = numbers.split(",")
            .map { LottoNumber.of(it) }
        return WinningLotto(
            winningLottoTicket = WinningLottoTicket(numbers = lottoNumbers),
            bonusNumber = LottoNumber(bonusNumber))
    }
}
