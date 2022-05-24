package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class MyLottoResultTest {

    @Test
    fun `당첨된 로또의 갯수가 몇개인지 결과를 반환한다`() {
        val myLottoResult = MyLottoResult(
            mapOf(
                LottoWinnerRank.FIRST_PRICE to 1,
                LottoWinnerRank.THIRD_PRICE to 2,
            )
        )

        assertAll(
            { Assertions.assertEquals(myLottoResult.getCount(LottoWinnerRank.FIRST_PRICE), 1) },
            { Assertions.assertEquals(myLottoResult.getCount(LottoWinnerRank.FIRST_PRICE), 1) },
            { Assertions.assertEquals(myLottoResult.getCount(LottoWinnerRank.THIRD_PRICE), 2) },
            { Assertions.assertEquals(myLottoResult.getCount(LottoWinnerRank.FOURTH_PRICE), 0) },
            { Assertions.assertEquals(myLottoResult.getCount(LottoWinnerRank.FIFTH_PRICE), 0) },
            { Assertions.assertEquals(myLottoResult.getCount(LottoWinnerRank.NONE), 0) },
        )
    }
}
