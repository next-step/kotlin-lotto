package lotto.fixture

import lotto.domain.LottoNumber

class LottoNumberFixture {

    companion object {
        val ONE = LottoNumber.of(1)
        val FIVE = LottoNumber.of(5)
        val SEVEN = LottoNumber.of(7)
        val TEN = LottoNumber.of(10)
        val ELEVEN = LottoNumber.of(11)
        val TWENTY_THREE = LottoNumber.of(23)
        val THIRTY = LottoNumber.of(30)
        val THIRTY_THREE = LottoNumber.of(33)
        val FORTY_FOUR = LottoNumber.of(44)
        val FORTY_FIVE = LottoNumber.of(45)
        val BONUS_BALL = FORTY_FIVE

        val DUPLICATED_LOTTO_NUMBER_LIST = listOf(ONE, ONE, SEVEN, THIRTY, FIVE, TWENTY_THREE)
        val LOTTO_NUMBER_LIST_OF_SEVEN = listOf(ONE, SEVEN, TEN, THIRTY, FORTY_FIVE, FIVE, TWENTY_THREE)

        val LOTTO_NUMBER_LIST_FIRST = listOf(ONE, FIVE, SEVEN, TEN, TWENTY_THREE, THIRTY)
        val LOTTO_NUMBER_LIST_SECOND = listOf(ONE, FIVE, SEVEN, TEN, THIRTY, FORTY_FIVE)
        val LOTTO_NUMBER_LIST_WINNING = listOf(ONE, FIVE, SEVEN, ELEVEN, TWENTY_THREE, FORTY_FOUR)
    }
}
