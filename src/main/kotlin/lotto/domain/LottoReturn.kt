package lotto.domain

data class LottoReturn(
    val firstCount: Int,
    val secondCount: Int,
    val thirdCount: Int,
    val fourthCount: Int,
    private val paidAmount: Int,
) {
    private val returnAmount: Long
        get() = firstCount * FIRST_RETURN +
                secondCount * SECOND_RETURN +
                thirdCount * THIRD_RETURN +
                fourthCount * FOURTH_RETURN

    val returnRatio: Float
        get() = returnAmount / paidAmount.toFloat()

    companion object {
        const val FIRST_RETURN: Long = 2000000000
        const val SECOND_RETURN: Long = 1500000
        const val THIRD_RETURN: Long = 50000
        const val FOURTH_RETURN: Long = 5000
    }
}
