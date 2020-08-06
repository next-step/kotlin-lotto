package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoCheckerTest {
    private lateinit var checker: LottoChecker

    @BeforeEach
    fun beforeTest() {
        val winnerLotto = WinnerLotto(
            Lotto(
                listOf(
                    LottoNo.from(1), LottoNo.from(2), LottoNo.from(3), LottoNo.from(4), LottoNo.from(6), LottoNo.from(7)
                )
            ),
            LottoNo.from(10)
        )
        val myLotto = Lotto(
            listOf(
                LottoNo.from(1), LottoNo.from(2), LottoNo.from(3), LottoNo.from(4), LottoNo.from(6), LottoNo.from(10)
            )
        )

        checker = LottoChecker(winnerLotto, listOf(myLotto))
    }

    @DisplayName(value = "일치하는 숫자의 개수와 로또의 상금을 확인한다.")
    @Test
    fun checkLottoResult() {
        assertThat(checker.getLottos()).allSatisfy {
            assertThat(it.win.matchNumber).isEqualTo(5)
            assertThat(it.win.matchBonus).isEqualTo(true)
            assertThat(it.checkPrize()).isEqualTo(Win.SECOND.prize)
        }
    }

    @Test
    fun `enum test`() {
        assertThat(Win.values().size).isEqualTo(6)
        assertThat(Win.THIRD.matchNumber).isEqualTo(5)
        assertThat(Win.FOURTH.prize.money).isEqualTo(50_000)
    }
}
