package camp.nextstep.edu.step.step2.domain.lotto

import camp.nextstep.edu.step.step2.domain.result.LottoMatch

data class WinningLotto(
    val userLottoTickets: List<Lotto>,
    val winningLotto: Lotto,
) {

    init {
        require(userLottoTickets.isNotEmpty()) { "구매한 로또가 없습니다." }
        require(winningLotto.numbers.isNotEmpty()) { "당첨번호가 입력되지 않았습니다." }
    }

    fun getTotalPriceByLottoAmountAndTicketPrice(ticketPrice: Long): Int {
        return userLottoTickets.size * ticketPrice.toInt()
    }

    fun getLottoMatchResult(): List<LottoMatch> {
        return userLottoTickets
            .map { numbers -> numbers.countMatch(winningLotto) }
            .map { LottoMatch.of(it) }
            .sorted()
    }

}
