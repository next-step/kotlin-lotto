package lotto

class LastWinningLotto(
    private val lottoTicket: LottoTicket,
    private val bonusNumber: LottoNumber
) {
    init {
        require(bonusNumber in lottoTicket) {
            "보너스 숫자는 지난 당첨번호에 포함될 수 없습니다."
        }
    }

    fun matchCount(targetLotto: LottoTicket): Int {
        return lottoTicket.matchCountWith(targetLotto)
    }

    fun hasBonusNumber(targetLotto: LottoTicket): Boolean {
        return bonusNumber in targetLotto
    }
}
