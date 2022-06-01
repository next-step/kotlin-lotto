package lotto

class LastWinningLotto(
    private val lastLottoWinnerTicket: LottoTicket,
    val bonusNumber: LottoNumber
) {
    init {
        require(!lastLottoWinnerTicket.hasNumber(bonusNumber)) {
            "보너스 숫자는 지난 당첨번호에 포함될 수 없습니다."
        }
    }

    fun matchCount(targetLotto: LottoTicket): Int {
        return lastLottoWinnerTicket.matchCountWith(targetLotto)
    }
}
