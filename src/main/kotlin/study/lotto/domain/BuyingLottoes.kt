package study.lotto.domain

data class BuyingLottoes(
    val buyingAutoLottoes: BuyingAutoLottoes,
    val buyingManualLottoes: BuyingManualLottoes,
) {
    fun toTotalList(): List<Lotto> = this.buyingAutoLottoes + this.buyingManualLottoes
}
