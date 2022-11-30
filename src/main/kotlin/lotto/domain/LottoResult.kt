package lotto.domain

class LottoResult(val purchasePrice: Int, val winningAmountList: List<Map<String, Int>>) {
    fun calculateReturnRate() {}
}