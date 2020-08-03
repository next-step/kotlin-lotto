package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {
    private lateinit var lotto: Lotto

    @BeforeEach
    fun beforeTest() {
        lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    }

    @DisplayName(value = "보유한 로또와 당첨로또를 비교하여 일치하는 숫자의 개수를 반환한다.")
    @Test
    fun validLottoCheck() {
        lotto.checkWin(Lotto(listOf(1, 2, 3, 4, 5, 7)))

        assertThat(lotto.win).isEqualTo(Win.SECOND)
        assertThat(lotto.checkPrize()).isEqualTo(Win.SECOND.prize)
    }

    @DisplayName(value = "두 리스트 비교")
    @Test
    fun compareLists() {
        val before = listOf(1, 2, 3, 4, 5, 6)
        val after = listOf(1, 2, 3, 4, 10, 9)

        assertThat(before.filter { it in after }.map { it }.size).isEqualTo(4)
    }
}
