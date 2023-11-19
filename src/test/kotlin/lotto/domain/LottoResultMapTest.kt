package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoResultMapTest {

    @DisplayName("미당첨을 제외한 로또 결과를 조회한다")
    @Test
    fun getLottoResultMapFilteredNotNoneTest() {
        // given
        val lottoResultMap = LottoResultMap.of(
            listOf(
                LottoResult.MATCH_6_NUMBERS,
                LottoResult.MATCH_4_NUMBERS,
                LottoResult.MATCH_5_NUMBERS,
                LottoResult.NONE,
            )
        )

        // when
        val filteredResultMap = lottoResultMap.getLottoResultMapFilteredNotNone()

        // then
        assertThat(filteredResultMap[LottoResult.MATCH_6_NUMBERS]).isEqualTo(1)
        assertThat(filteredResultMap[LottoResult.MATCH_5_NUMBERS]).isEqualTo(1)
        assertThat(filteredResultMap[LottoResult.MATCH_4_NUMBERS]).isEqualTo(1)
        assertThat(filteredResultMap[LottoResult.MATCH_3_NUMBERS]).isZero
    }

    @DisplayName("로또 결과 별 개수를 조회한다")
    @Test
    fun getLottoResultCountTest() {
        // given
        val lottoResultMap = LottoResultMap.of(
            listOf(
                LottoResult.MATCH_6_NUMBERS,
                LottoResult.NONE,
            )
        )
        val result = LottoResult.MATCH_6_NUMBERS

        // when
        val count = lottoResultMap.getLottoResultCount(result)

        // then
        assertThat(count).isEqualTo(1)
    }

    @DisplayName("전체 로또 개수를 조회한다")
    @Test
    fun getTotalCountTest() {
        // given
        val lottoResultMap = LottoResultMap.of(
            listOf(
                LottoResult.MATCH_6_NUMBERS,
                LottoResult.MATCH_4_NUMBERS,
                LottoResult.MATCH_5_NUMBERS,
                LottoResult.NONE,
            )
        )

        // when
        val count = lottoResultMap.getTotalCount()

        // then
        assertThat(count).isEqualTo(4)
    }

    @DisplayName("당첨 금액을 조회한다")
    @Test
    fun getWinningPriceTest() {
        // given
        val lottoResultMap = LottoResultMap.of(
            listOf(
                LottoResult.MATCH_6_NUMBERS,
                LottoResult.MATCH_4_NUMBERS,
                LottoResult.MATCH_5_NUMBERS,
                LottoResult.NONE,
            )
        )

        // when
        val actual = lottoResultMap.getWinningPrice()

        // then
        val expected = (
            LottoResult.MATCH_6_NUMBERS.price +
                LottoResult.MATCH_4_NUMBERS.price +
                LottoResult.MATCH_5_NUMBERS.price
            ).toDouble()
        assertThat(actual).isEqualTo(expected)
    }
}
