package lotto.domain

data class PaymentResult(
    val lottoes: List<Lotto>,
    val change: Int
) {

    override fun toString(): String = "${lottoes.joinToString("\n")}\n거스름돈 : $change"
}
