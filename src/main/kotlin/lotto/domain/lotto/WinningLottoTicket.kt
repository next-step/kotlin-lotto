package lotto.domain.lotto

class WinningLottoTicket private constructor(
    val lottoTicket: LottoTicket,
    private val bonus: LottoNumber
) {

    fun matchBonus(userLottoTicket: LottoTicket) = userLottoTicket.hasNumber(bonus)

    override fun toString(): String = "${super.toString()}, ${bonus.value}"

    companion object {

        fun of(lottoTicket: LottoTicket, bonus: LottoNumber): WinningLottoTicket? {
            if (lottoTicket.hasNumber(bonus)) {
                return null
            }
            return WinningLottoTicket(lottoTicket, bonus)
        }

        fun of(lottoTicket: LottoTicket, bonus: Int): WinningLottoTicket? = try {
            of(lottoTicket, LottoNumber.of(bonus))
        } catch (e: IllegalArgumentException) {
            null
        }
    }
}
