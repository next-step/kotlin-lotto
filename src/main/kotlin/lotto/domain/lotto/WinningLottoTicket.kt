package lotto.domain.lotto

class WinningLottoTicket private constructor(
    val lottoTicket: LottoTicket,
    private val bonus: LottoNumber
) {

    fun matchCount(userLottoTicket: LottoTicket) = lottoTicket.numbers.count { userLottoTicket.hasNumber(it) }

    fun matchBonus(userLottoTicket: LottoTicket) = userLottoTicket.hasNumber(bonus)

    override fun toString(): String = "${super.toString()}, ${bonus.value}"

    companion object {

        operator fun invoke(lottoTicket: LottoTicket, bonus: LottoNumber): WinningLottoTicket? {
            if (lottoTicket.hasNumber(bonus)) {
                return null
            }
            return WinningLottoTicket(lottoTicket, bonus)
        }

        operator fun invoke(lottoTicket: LottoTicket, bonus: Int): WinningLottoTicket? {
            val lottoNumber = LottoNumber(bonus) ?: return null
            return invoke(lottoTicket, lottoNumber)
        }
    }
}
