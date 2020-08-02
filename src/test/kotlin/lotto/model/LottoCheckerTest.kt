package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoCheckerTest {
    private lateinit var checker: LottoChecker

    @BeforeEach
    fun beforeTest() {
        val winnerLotto = Lotto(mutableListOf(1, 2, 3, 4, 5, 6))
        val myLotto = Lotto(mutableListOf(1, 2, 6, 7, 10, 13))

        checker = LottoChecker(winnerLotto, listOf(myLotto))
    }

    @DisplayName(value = "일치하는 숫자의 개수와 로또의 상금을 확인한다.")
    @Test
    fun checkLottoResult() {
        assertThat(checker.getLottos()).allSatisfy {
            assertThat(it.matchNumberCount).isEqualTo(3)
            assertThat(it.prize).isEqualTo(Lotto.Win.FOURTH.prize)
        }
    }

    @Test
    fun `enum test`() {
        assertThat(Lotto.Win.values().size).isEqualTo(4)
        assertThat(Lotto.Win.THIRD.matchNumber).isEqualTo(4)
        assertThat(Lotto.Win.FOURTH.prize).isEqualTo(5000)
    }
}
