package lotto.adapter.`in`

class PurchaseRequest private constructor (val amount: Int) {
    companion object {
        fun from(inputAmount: String): PurchaseRequest {
            val amount = inputAmount.toIntOrNull() ?: throw IllegalArgumentException("구입 금액은 정수여야 합니다")

            require(amount > 0) { "구입 금액은 0보다 커야 합니다." }
            require(amount % 1000 == 0) { "구입 금액은 1000원 단위여야 합니다." }

            return PurchaseRequest(amount)
        }
    }
}
