package study.lotto.domain

data class BuyingLottoes(
    val buyingAuto: Lottoes,
    val buyingManual: Lottoes
) {
    fun getAll(): Lottoes = buyingAuto + buyingManual
}
