package camp.nextstep.edu.step.step2.domain.amount

@JvmInline
value class ManualTicketAmount(
    val amount: Long
) {

    init {
        require(amount > 0) { "구매 금액은 0보다 커야 합니다." }
    }

}
