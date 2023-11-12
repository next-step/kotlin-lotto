package lotto

sealed class LottoRanking(val matchingNumberCnt: Int, val price: Int) {
    object FirstPlace : LottoRanking(FIRST_PLACE_MATCHING_NUMBER_CNT, FIRST_PLACE_MATCHING_PRICE)
    object SecondPlace : LottoRanking(SECOND_PLACE_MATCHING_NUMBER_CNT, SECOND_PLACE_MATCHING_PRICE)
    object ThirdPlace : LottoRanking(THIRD_PLACE_MATCHING_NUMBER_CNT, THIRD_PLACE_MATCHING_PRICE)
    object FourthPlace : LottoRanking(FOURTH_PLACE_MATCHING_NUMBER_CNT, FOURTH_PLACE_MATCHING_PRICE)
    object None : LottoRanking(NONE_PLACE_MATCHING_NUMBER_CNT , NONE_PLACE_MATCHING_PRICE)

    companion object {
        private const val FIRST_PLACE_MATCHING_NUMBER_CNT = 6
        private const val SECOND_PLACE_MATCHING_NUMBER_CNT = 5
        private const val THIRD_PLACE_MATCHING_NUMBER_CNT = 4
        private const val FOURTH_PLACE_MATCHING_NUMBER_CNT = 3
        private const val NONE_PLACE_MATCHING_NUMBER_CNT = 0

        private const val FIRST_PLACE_MATCHING_PRICE = 2000000000
        private const val SECOND_PLACE_MATCHING_PRICE = 1500000
        private const val THIRD_PLACE_MATCHING_PRICE = 50000
        private const val FOURTH_PLACE_MATCHING_PRICE = 5000
        private const val NONE_PLACE_MATCHING_PRICE = 0
    }
}
