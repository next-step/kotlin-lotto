package lotto

import lotto.domain.LottoSingleLine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoSIngleLineTest {
    @Test
    fun `로또 한줄 생성 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        assertThat(lottoSingleLine.getNumbers().size).isEqualTo(6)
        assertThat(lottoSingleLine.getNumbers().fold(true, { t1, t2 -> t1 && t2 is Int })).isEqualTo(true)
    }

    @Test
    fun `1등 당첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.getNumbers()
        lottoSingleLine.checkPlace(result)
        assertThat(lottoSingleLine.getResult().matchCount).isEqualTo(6)
    }

    @Test
    fun `2등 당첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.getNumbers().toMutableList()
        result[result.lastIndex] = 0
        lottoSingleLine.checkPlace(result)
        assertThat(lottoSingleLine.getResult().matchCount).isEqualTo(5)
    }

    @Test
    fun `3등 당첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.getNumbers().toMutableList()
        result[result.lastIndex - 1] = 0
        result[result.lastIndex] = 0
        lottoSingleLine.checkPlace(result)
        assertThat(lottoSingleLine.getResult().matchCount).isEqualTo(4)
    }

    @Test
    fun `4등 당첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.getNumbers().toMutableList()
        result[result.lastIndex - 2] = 0
        result[result.lastIndex - 1] = 0
        result[result.lastIndex] = 0
        lottoSingleLine.checkPlace(result)
        assertThat(lottoSingleLine.getResult().matchCount).isEqualTo(3)
    }

    @Test
    fun `5등 당첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.getNumbers().toMutableList()
        result[result.lastIndex - 3] = 0
        result[result.lastIndex - 2] = 0
        result[result.lastIndex - 1] = 0
        result[result.lastIndex] = 0
        lottoSingleLine.checkPlace(result)
        assertThat(lottoSingleLine.getResult().matchCount).isEqualTo(2)
    }

    @Test
    fun `6등 당첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.getNumbers().toMutableList()
        result[result.lastIndex - 4] = 0
        result[result.lastIndex - 3] = 0
        result[result.lastIndex - 2] = 0
        result[result.lastIndex - 1] = 0
        result[result.lastIndex] = 0
        lottoSingleLine.checkPlace(result)
        assertThat(lottoSingleLine.getResult().matchCount).isEqualTo(1)
    }

    @Test
    fun `낙첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.getNumbers().toMutableList()
        result[result.lastIndex - 5] = 0
        result[result.lastIndex - 4] = 0
        result[result.lastIndex - 3] = 0
        result[result.lastIndex - 2] = 0
        result[result.lastIndex - 1] = 0
        result[result.lastIndex] = 0
        lottoSingleLine.checkPlace(result)
        assertThat(lottoSingleLine.getResult().matchCount).isEqualTo(0)
    }
}
