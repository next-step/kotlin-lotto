package lotto.service

import lotto.view.OutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal

class LottoShopTest {
    @Test
    internal fun `N*1000원을 입력하면 N개가 발급된다`() {
        val lottos = LottoShop.buy(BigDecimal(5999))
        assertThat(lottos.size).isEqualTo(5)
    }

    @Test
    internal fun `1000원 미만 금액이 들어오면 RuntimeException`() {
        assertThrows<IllegalArgumentException> { LottoShop.buy(BigDecimal(999)) }
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "2:0",
            "3:5000",
            "4:50000",
            "5:1500000",
            "6:2000000000"
        ],
        delimiter = ':'
    )
    internal fun `일치 갯수에 따라 당첨금액을 출력한다`(matchCount: Int, expectedPrize: BigDecimal) {
        val prize = LottoShop.prizeOf(matchCount)
        assertThat(prize).isEqualTo(expectedPrize)
    }

    @Test
    internal fun `당첨 이후 총 수익률을 계산한다`() { // TODO 로직을 어디다 옮길지 고민
        val lottoCount = 7
        val winningPrize = BigDecimal.valueOf(1_234_567)
        val returnRatio = OutputView.returnRatioOf(lottoCount, winningPrize)
        assertThat(returnRatio).isEqualTo(BigDecimal("176.37"))
    }
}
