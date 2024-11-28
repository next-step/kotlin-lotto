package lotto.domain

data class Lotties(
    val manualLotties: List<Lotto>,
    val autoLotties: List<Lotto>,
) {
    val all = manualLotties + autoLotties
}
