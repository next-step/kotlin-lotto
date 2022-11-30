package lotto.domain

class LottoResult(val purchasePrice: Int, val winningAmountList: Map<Int, Int>) {
    fun calculateReturnRate() {}
}