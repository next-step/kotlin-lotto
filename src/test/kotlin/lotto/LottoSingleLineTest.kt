package lotto

import lotto.domain.LottoResult
import lotto.domain.LottoSingleLine
import lotto.domain.getPlace
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoSingleLineTest {
    @Test
    fun `로또 한줄 생성 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        assertThat(lottoSingleLine.lottoNumbers.size).isEqualTo(LOTTO_NUMBERS_COUNT)
        assertThat(lottoSingleLine.lottoNumbers.fold(true, { t1, t2 -> t1 && t2 is Int })).isEqualTo(true)
    }

    @Test
    fun `1등 당첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.lottoNumbers
        lottoSingleLine.checkPlace(result, -1)
        assertThat(getPlace(lottoSingleLine.getResult().matchCount, false).price).isEqualTo(LottoResult.FIRST.price)
    }

    @Test
    fun `2등 당첨 테스트-BONUS TRUE`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.lottoNumbers.toMutableList()
        result[result.lastIndex] = 0
        lottoSingleLine.checkPlace(result, 0)
        assertThat(
            getPlace(
                lottoSingleLine.getResult().matchCount,
                true
            ).price
        ).isEqualTo(LottoResult.SECOND_BONUS.price)
    }

    @Test
    fun `2등 당첨 테스트-BONUS FALSE`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.lottoNumbers.toMutableList()
        result[result.lastIndex] = 0
        lottoSingleLine.checkPlace(result, -1)
        assertThat(getPlace(lottoSingleLine.getResult().matchCount, false).price).isEqualTo(LottoResult.SECOND.price)
    }

    @Test
    fun `3등 당첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.lottoNumbers.toMutableList()
        result[result.lastIndex - 1] = 0
        result[result.lastIndex] = 0
        lottoSingleLine.checkPlace(result, -1)
        assertThat(getPlace(lottoSingleLine.getResult().matchCount, false).price).isEqualTo(LottoResult.THIRD.price)
    }

    @Test
    fun `4등 당첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.lottoNumbers.toMutableList()
        result[result.lastIndex - 2] = 0
        result[result.lastIndex - 1] = 0
        result[result.lastIndex] = 0
        lottoSingleLine.checkPlace(result, -1)
        assertThat(getPlace(lottoSingleLine.getResult().matchCount, false).price).isEqualTo(LottoResult.FOURTH.price)
    }

    @Test
    fun `5등 당첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.lottoNumbers.toMutableList()
        result[result.lastIndex - 3] = 0
        result[result.lastIndex - 2] = 0
        result[result.lastIndex - 1] = 0
        result[result.lastIndex] = 0
        lottoSingleLine.checkPlace(result, -1)
        assertThat(getPlace(lottoSingleLine.getResult().matchCount, false).price).isEqualTo(LottoResult.FIFTH.price)
    }

    @Test
    fun `6등 당첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.lottoNumbers.toMutableList()
        result[result.lastIndex - 4] = 0
        result[result.lastIndex - 3] = 0
        result[result.lastIndex - 2] = 0
        result[result.lastIndex - 1] = 0
        result[result.lastIndex] = 0
        lottoSingleLine.checkPlace(result, -1)
        assertThat(getPlace(lottoSingleLine.getResult().matchCount, false).price).isEqualTo(LottoResult.SIX.price)
    }

    @Test
    fun `낙첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.lottoNumbers.toMutableList()
        result[result.lastIndex - 5] = 0
        result[result.lastIndex - 4] = 0
        result[result.lastIndex - 3] = 0
        result[result.lastIndex - 2] = 0
        result[result.lastIndex - 1] = 0
        result[result.lastIndex] = 0
        lottoSingleLine.checkPlace(result, -1)
        assertThat(getPlace(lottoSingleLine.getResult().matchCount, false).price).isEqualTo(LottoResult.NONE.price)
    }
}
