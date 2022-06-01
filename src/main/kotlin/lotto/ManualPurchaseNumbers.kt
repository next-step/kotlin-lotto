package lotto

data class ManualPurchaseNumbers(
    val bunchOfNumbers: List<List<LottoNumber>>
) {
    val count = bunchOfNumbers.size
}
