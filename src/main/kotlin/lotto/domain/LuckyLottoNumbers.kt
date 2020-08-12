package lotto.domain

class LuckyLottoNumbers(
    private val luckyTicket: LottoTicket,
    private val bonusNumber: LottoNumber
) {
    init {
        require(!luckyTicket.has(bonusNumber)) { "보너스 번호 ($bonusNumber)는 당첨번호($luckyTicket)와 중복될 수 없습니다." }
    }

    constructor(vararg luckyNumbers: Int, bonusNumber: Int) : this(
        LottoTicket(*luckyNumbers),
        LottoNumber.of(bonusNumber)
    )

    fun getLottoResultsWith(lottoTickets: LottoTickets): LottoResults {
        return lottoTickets.tickets.map { getLottoResultOf(it) }
            .groupingBy { it }
            .eachCount()
            .let { LottoResults(it) }
    }

    private fun getLottoResultOf(lottoTicket: LottoTicket): LottoResult {
        val matchCount = lottoTicket.getMatchCountWith(luckyTicket)
        val hasBonus = lottoTicket.has(bonusNumber)
        return LottoResult.findByMatch(matchCount, hasBonus)
    }
}
