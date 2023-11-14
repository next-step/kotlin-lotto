package camp.nextstep.edu.step.step2.domain.store

import camp.nextstep.edu.step.step2.domain.lotto.Lotto

@JvmInline
value class LottoTickets(
    val lottoTicketAmount: Int
) {

    init {
        require(lottoTicketAmount > 0) { "로또 티켓은 1개 이상이어야 합니다." }
    }

    /**
     * @description : 로또 티켓 수량에 따른 로또 번호를 생성한다.
     */
    fun createNumbersByLottoTicketAmount(): List<Lotto> {
        return (1..lottoTicketAmount)
            .map { Lotto.generateAutoNumbers() }
            .distinct()
    }

}
