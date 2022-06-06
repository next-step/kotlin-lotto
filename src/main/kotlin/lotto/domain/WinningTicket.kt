package lotto.domain

class WinningTicket(private val lottoTicket: LottoTicket) {
    val numbers = lottoTicket.numbers
    var bonusNumber = 0
        private set

    fun chooseBonusBall(input: String) {
        bonusNumber = input.toInt()
        require(!numbers.contains(bonusNumber)) { "보너스 번호가 로또 번호와 중복됩니다." }
    }
}
