package study.lotto.domain

data class BuyingLottoes(
    val buyingAutoLottoes: BuyingAutoLottoes,
    val buyingManualLottoes: BuyingManualLottoes,
    val totalList: List<Lotto> = buyingAutoLottoes + buyingManualLottoes,
)
