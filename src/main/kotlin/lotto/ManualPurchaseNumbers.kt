package lotto

data class ManualPurchaseNumbers(
    val bunchOfNumbers: List<List<Int>>
) {
    val count = bunchOfNumbers.size
}
