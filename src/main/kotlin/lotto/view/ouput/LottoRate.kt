package lotto.view.ouput

data class LottoRate(val rate: Double) {
    constructor(sumAmount: Long, totalAmount: Int) : this(sumAmount.toDouble() / totalAmount.toDouble())
}
