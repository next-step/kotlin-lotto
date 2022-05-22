package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MyLottoResultTest {

    @Test
    fun `당첨된 로또의 갯수가 몇개인지 결과를 반환한다`() {
        val myLottoResult = MyLottoResult(
            mapOf(
                LottoWinnerRank.FIRST_PRICE to 1,
                LottoWinnerRank.SECOND_PRICE to 2,
            )
        )

        assertThat(myLottoResult.getCount(LottoWinnerRank.FIRST_PRICE)).isEqualTo(1)
        assertThat(myLottoResult.getCount(LottoWinnerRank.SECOND_PRICE)).isEqualTo(2)
        assertThat(myLottoResult.getCount(LottoWinnerRank.THIRD_PRICE)).isEqualTo(0)
        assertThat(myLottoResult.getCount(LottoWinnerRank.FOURTH_PRICE)).isEqualTo(0)
        assertThat(myLottoResult.getCount(LottoWinnerRank.NONE)).isEqualTo(0)
    }
}
