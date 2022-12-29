package lotto.model

class TicketQuantity(money: String) {
    val quantity: Int = convertNumber(money)

    private fun convertNumber(money: String): Int {
        var amount = money.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능합니다.")

        require(amount >= 1000) { "1000원 이상을 결제해주세요." }
        require(amount % 1000 == 0) { "1000원 단위로 결제해주세요." }

        amount /= 1000

        return amount
    }
}
