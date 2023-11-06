package lotto

data class LottoStatResult(
    val firstCount: Int,
    val thirdCount: Int,
    val fourthCount: Int,
    val fifthCount: Int,
    val purchaseAmount: Int,
) {
    companion object {
        const val FIRST_PLACE_REWARD = 2000000000
        const val THIRD_PLACE_REWARD = 1500000
        const val FOURTH_PLACE_REWARD = 50000
        const val FIFTH_PLACE_REWARD = 5000
    }
}
