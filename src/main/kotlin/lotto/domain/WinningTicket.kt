package lotto.domain

class WinningTicket(
    private val winningTicket: LottoTicket,
    private val bonusNumber: LottoNumber
) {
    fun containNumber(lottoNumber: LottoNumber): Boolean = winningTicket.containNumber(lottoNumber)
    fun containBonusNumber(numbers: Set<LottoNumber>): Boolean = numbers.contains(bonusNumber)

    init {
        require(winningTicket.notContainNumber(bonusNumber)) { "$bonusNumber 은 이미 당첨 번호로 입력된 값이에요" }
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
