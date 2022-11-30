package lotto.domain

class WinningTicket(
    private val winningTicket: LottoTicket,
    private val bonusNumber: LottoNumber
) {
    init {
        require(winningTicket.notContainNumber(bonusNumber)) { "$bonusNumber 은 이미 당첨 번호로 입력된 값이에요" }
    }

    fun match(lottoTicket: LottoTicket): Award {
        val matchCount = lottoTicket.matchCount(winningTicket)
        return Award.of(matchCount, lottoTicket.containNumber(bonusNumber))
    }


    companion object {
        fun of(numbers: List<Int>, bonusNumber: Int): WinningTicket {
            return WinningTicket(
                LottoTicket(numbers.map { LottoNumber.of(it) }),
                LottoNumber.of(bonusNumber)
            )
        }
    }
}
