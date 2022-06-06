package lotto.domain

class WinningTicket(private val lottoTicket: LottoTicket) {
    val numbers = lottoTicket.numbers
    var bonusNumber = 0
        private set

    fun chooseBonusBall(input: String) {
        bonusNumber = input.toInt()
    }
}
