package lotto.domain

import lotto.LottoUtils.bonusNumber
import lotto.LottoUtils.luckyNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ResultTest {
    private lateinit var result: Result
    private lateinit var lottoNumbers: LottoNumbers
    private lateinit var lotto: Lotto
    private lateinit var lottos: Lottos
    private lateinit var shouldBeResult: Map<Rank, Int>

    @DisplayName("2등 하나만 당첨되도록 세팅한다")
    @BeforeEach
    fun `set up`() {
        // given
        lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        luckyNumbers = LuckyNumbers(listOf(1, 2, 3, 4, 5, 7))
        bonusNumber = BonusNumber(6)

        lotto = Lotto(lottoNumbers)
        lottos = Lottos(listOf(lotto))
        result = Result(lottos)

        shouldBeResult = mapOf(
            Rank.FIFTH to 0,
            Rank.FOURTH to 0,
            Rank.THIRD to 0,
            Rank.SECOND to 1,
            Rank.FIRST to 0
        )
    }

    @DisplayName("2등만 1 올라간 상태로 당첨 결과를 반환한다")
    @Test
    fun `get result`() {
        assertThat(result.getResult()).isEqualTo(shouldBeResult)
    }

    @Test
    fun `get profit`() {
        assertThat(result.getProfit()).isEqualTo(30000000)
    }
}
