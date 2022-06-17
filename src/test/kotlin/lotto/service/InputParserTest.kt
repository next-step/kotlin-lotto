package lotto.service

import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputParserTest {

    @Test
    fun `구매 금액을 파싱할 수 있다`() {
        val result = InputParser.parsePurchaseAmount("14000")

        assertThat(result).isEqualTo(14000)
    }

    @Test
    fun `당첨 번호를 파싱할 수 있다`() {
        val result = InputParser.parseWinningNumbers("1, 2, 3, 4, 5, 6")

        assertThat(result).isEqualTo(
            listOf(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
            )
        )
    }

    @Test
    fun `보너스 번호를 파싱할 수 있다`() {
        val result = InputParser.parseBonusNumber("1")

        assertThat(result).isEqualTo(LottoNumber.of(1))
    }
}
