package lotto.model

@JvmInline
value class PurchasePrice(val purchasePrice: Int) {
    init {
        require(purchasePrice >= 0) {
            "구매 금액은 0 또는 자연수입니다."
        }
    }

    operator fun minus(purchasePrice: Int): PurchasePrice {
        return PurchasePrice(this.purchasePrice - purchasePrice)
    }

    operator fun minus(purchasePrice: PurchasePrice): PurchasePrice {
        return PurchasePrice(this.purchasePrice - purchasePrice.purchasePrice)
    }

    operator fun compareTo(purchasePrice: PurchasePrice): Int {
        return this.purchasePrice - purchasePrice.purchasePrice
    }

    companion object {
        fun from(purchasePrice: Int): PurchasePrice {
            return PurchasePrice(purchasePrice)
        }
    }
}
