package lotto

class Lotto(
    private val payment: Int
) {

    fun issuanceCount(): Int {
        val countLotto = payment.div(LOTTO_PRICE)
        val remPayment = payment.rem(LOTTO_PRICE)
        require(remPayment == 0) { CANNOT_ISSUANCE_LOTTO }
        return countLotto
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val CANNOT_ISSUANCE_LOTTO = "지불 금액이 맞지 않아 로또로 바꿔드릴 수 없습니다."
    }
}
