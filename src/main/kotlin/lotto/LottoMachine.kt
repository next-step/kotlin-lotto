package lotto

class LottoMachine(
    dto: InputPaymentRequestDto
) {

    private val inputPayment: Int = dto.payment

    init {
        require(inputPayment >= Lotto.LOTTO_PRICE) { INVALID_PAYMENT }
        val remPayment = inputPayment.rem(Lotto.LOTTO_PRICE)
        require(remPayment == 0) { CANNOT_ISSUANCE_LOTTO }
    }

    companion object {
        const val INVALID_PAYMENT = "지불 금액이 1000원 이상이여야한다."
        const val CANNOT_ISSUANCE_LOTTO = "지불 금액이 맞지 않아 로또로 바꿔드릴 수 없습니다."
    }
}
