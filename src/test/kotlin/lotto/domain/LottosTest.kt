package lotto.domain

import lotto.LottoUtils.bonusNumber
import lotto.LottoUtils.luckyNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottosTest {
    private val lottoNumbers1 = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
    private val lottoNumbers2 = LottoNumbers(listOf(1, 2, 3, 20, 30, 40))

    private lateinit var lottos: Lottos
    private val shouldBeResult = listOf(
        Pair(6, false),
        Pair(3, true)
    )

    @BeforeEach
    fun `set up`() {
        luckyNumbers = LuckyNumbers(listOf(1, 2, 3, 4, 5, 6))
        bonusNumber = BonusNumber(20)
        lottos = Lottos(
            listOf(
                Lotto(lottoNumbers1),
                Lotto(lottoNumbers2)
            )
        )
    }

    @DisplayName("toString()을 하면, 모든 로또의 번호를 반환한다")
    @Test
    fun `matched results`() {
        assertThat(lottos.matchResults(luckyNumbers, bonusNumber)).isEqualTo(shouldBeResult)
    }
}
