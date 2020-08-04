package lotto

import lotto.domain.LottoLines
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoLinesTest {
    @ParameterizedTest
    @CsvSource(
        "10000,10",
        "20000,20",
        "30000,30",
        "40000,40"
    )
    fun `로또 티켓(여러줄) 생성 테스트`(inputMoney: Int, gameCount: Int) {
        val totalNumber = inputMoney / LINE_PRICE
        val lottoTicket = LottoLines(totalNumber)
        Assertions.assertThat(lottoTicket.getLines().size).isEqualTo(gameCount)
    }
}
