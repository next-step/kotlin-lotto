package lotto

import lotto.domain.LottoSingleLine
import lotto.domain.LottoLines
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {
    @Test
    fun `로또 한줄 생성 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        assertThat(lottoSingleLine.getNumbers().size).isEqualTo(6)
        assertThat(lottoSingleLine.getNumbers().fold(true, { t1, t2 -> t1 && t2 is Int })).isEqualTo(true)
    }

    @ParameterizedTest
    @CsvSource(
        "10000,10",
        "20000,20",
        "30000,30",
        "40000,40"
    )

    @Test
    fun `1등 당첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.getNumbers()
        assertThat(lottoSingleLine.matching(result)).isEqualTo(6)
    }

    @Test
    fun `2등 당첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.getNumbers().toMutableList()
        result[result.lastIndex] = 0
        assertThat(lottoSingleLine.matching(result)).isEqualTo(5)
    }

    @Test
    fun `3등 당첨 테스트`() {
        val lottoSingleLine = LottoSingleLine()
        val result = lottoSingleLine.getNumbers().toMutableList()
        result[result.lastIndex - 1] = 0
        result[result.lastIndex] = 0
        assertThat(lottoSingleLine.matching(result)).isEqualTo(5)
    }

    fun `로또 티켓(여러줄) 생성 테스트`(inputMoney: Int, gameCount: Int) {
        val totalNumber = inputMoney / LINE_PRICE
        val lottoTicket = LottoLines(totalNumber)
        assertThat(lottoTicket.getLines().size).isEqualTo(gameCount)
    }
}
