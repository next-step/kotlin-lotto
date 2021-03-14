package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoPrizeTest {

    @Test
    fun `로또번호가 6개 일치하는 경우 1등이다`() {
        val matchedLottoNumberCount = 6
        val expected = LottoPrize.FIRST_PRIZE
        val result = LottoPrize.valueOf(matchedLottoNumberCount)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `로또번호가 5개 일치하는 경우 3등이다`() {
        val matchedLottoNumberCount = 5
        val expected = LottoPrize.THIRD_PRIZE
        val result = LottoPrize.valueOf(matchedLottoNumberCount)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `로또번호가 4개 일치하는 경우 4등이다`() {
        val matchedLottoNumberCount = 4
        val expected = LottoPrize.FOURTH_PRIZE
        val result = LottoPrize.valueOf(matchedLottoNumberCount)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `로또번호가 3개 일치하는 경우 5등이다`() {
        val matchedLottoNumberCount = 3
        val expected = LottoPrize.FIFTH_PRIZE
        val result = LottoPrize.valueOf(matchedLottoNumberCount)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `로또번호가 2개 일치하는 경우 꽝이다`() {
        val matchedLottoNumberCount = 2
        val expected = LottoPrize.WHACK
        val result = LottoPrize.valueOf(matchedLottoNumberCount)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `로또번호가 1개 일치하는 경우 꽝이다`() {
        val matchedLottoNumberCount = 1
        val expected = LottoPrize.WHACK
        val result = LottoPrize.valueOf(matchedLottoNumberCount)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `로또번호가 0개 일치하는 경우 꽝이다`() {
        val matchedLottoNumberCount = 0
        val expected = LottoPrize.WHACK
        val result = LottoPrize.valueOf(matchedLottoNumberCount)
        assertThat(result).isEqualTo(expected)
    }
}
