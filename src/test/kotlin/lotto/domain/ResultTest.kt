package lotto.domain

import lotto.LottoUtils.luckyNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ResultTest {
    private lateinit var result: Result
    private lateinit var lotto: Lotto
    private lateinit var lottos: Lottos
    private lateinit var shouldBeResult: Map<PrizeMoney, Int>

    @DisplayName("4등 하나만 당첨되도록 세팅한다")
    @BeforeEach
    fun `set up`() {
        // given
        lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        lottos = Lottos(listOf(lotto))

        luckyNumbers = listOf(1, 2, 3, 4, 5, 6)

        result = Result(lottos)

        shouldBeResult = mapOf(
            PrizeMoney.FOURTH to 1,
            PrizeMoney.THIRD to 0,
            PrizeMoney.SECOND to 0,
            PrizeMoney.FIRST to 0
        )
    }

    @DisplayName("4등만 1 올라간 상태로 당첨 결과를 반환한다")
    @Test
    fun `get result`() {
        assertThat(result.getResult()).isEqualTo(shouldBeResult)
    }

    @DisplayName("당첨금이 구입금액의 절반일 때, 수익률을 0.50로 반환한다")
    @Test
    fun `profit ratio`() {
        assertThat(result.getProfitRatio(payment = 10000)).isEqualTo(BigDecimal(0.50).setScale(2))
    }
}
