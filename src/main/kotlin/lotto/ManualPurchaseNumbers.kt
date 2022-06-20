package lotto

data class ManualPurchaseNumbers(
    val bunchOfNumbers: LottoBundle
) {
    val count = bunchOfNumbers.count()
}
