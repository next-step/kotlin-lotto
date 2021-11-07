package lotto.fixture

import lotto.domain.LottoNumber

class LottoNumberFixture {

    companion object {
        private val ONE = LottoNumber.of(1)
        private val FIVE = LottoNumber.of(5)
        private val SEVEN = LottoNumber.of(7)
        private val TEN = LottoNumber.of(10)
        private val ELEVEN = LottoNumber.of(11)
        private val TWENTY_THREE = LottoNumber.of(23)
        private val THIRTY = LottoNumber.of(30)
        private val THIRTY_THREE = LottoNumber.of(33)
        private val FORTY_FOUR = LottoNumber.of(44)
        private val FORTY_FIVE = LottoNumber.of(45)

        val DUPLICATED_LOTTO_NUMBER_LIST = listOf(ONE, ONE, SEVEN, THIRTY, FIVE, TWENTY_THREE)
        val LOTTO_NUMBER_LIST_OF_SEVEN = listOf(ONE, SEVEN, TEN, THIRTY, FORTY_FIVE, FIVE, TWENTY_THREE)

        val LOTTO_NUMBER_LIST_FIRST = listOf(ONE, FIVE, SEVEN, TEN, TWENTY_THREE, THIRTY)
        val LOTTO_NUMBER_LIST_SECOND = listOf(ONE, FIVE, SEVEN, TEN, THIRTY, FORTY_FIVE)
        val LOTTO_NUMBER_LIST_WINNING = listOf(ONE, FIVE, SEVEN, ELEVEN, TWENTY_THREE, FORTY_FOUR)
    }
}
