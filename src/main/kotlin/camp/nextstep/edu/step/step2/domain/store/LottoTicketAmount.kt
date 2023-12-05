package camp.nextstep.edu.step.step2.domain.store

@JvmInline
value class LottoTicketAmount(
    val lottoTicketAmount: Int
) {

    init {
        require(lottoTicketAmount > 0) { "로또 티켓은 1개 이상이어야 합니다." }
    }

}
