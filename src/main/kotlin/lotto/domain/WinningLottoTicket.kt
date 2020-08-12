package lotto.domain

data class WinningLottoTicket(
    val lottoTicket: LottoTicket,
    private val bonus: LottoNumber
) {

    init {
        require(!lottoTicket.hasNumber(bonus)) { "보너스 번호는 당첨 번호와 중복되면 안됩니다." }
    }

    constructor(lottoTicket: LottoTicket, bonus: Int) : this(lottoTicket, LottoNumber(bonus))

    fun matchCount(userLottoTicket: LottoTicket) = lottoTicket.numbers.count { userLottoTicket.hasNumber(it) }

    fun matchBonus(userLottoTicket: LottoTicket) = userLottoTicket.hasNumber(bonus)

    override fun toString(): String = "${super.toString()}, ${bonus.value}"
}
