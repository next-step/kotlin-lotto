package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {
    private lateinit var lotto: Lotto

    @BeforeEach
    fun beforeTest() {
        lotto = Lotto(listOf(LottoNo("1"), LottoNo("2"), LottoNo("3"), LottoNo("4"), LottoNo("5"), LottoNo("6")))
    }

    @DisplayName(value = "보유한 로또와 당첨로또를 비교하여 일치하는 숫자의 개수를 반환한다.")
    @Test
    fun validLottoCheck() {
        lotto.checkWin(
            WinnerLotto(
                Lotto(listOf(LottoNo("1"), LottoNo("2"), LottoNo("3"), LottoNo("4"), LottoNo("5"), LottoNo("10"))), LottoNo("6")
            )
        )
        assertThat(lotto.win).isEqualTo(Win.SECOND)
        assertThat(lotto.checkPrize()).isEqualTo(Win.SECOND.prize)
    }

    @DisplayName(value = "로또 내에 중복되는 숫자가 있는지 확인한다")
    @Test
    fun repeatCheck() {
        assertThatThrownBy {
            Lotto(listOf(LottoNo("1"), LottoNo("2"), LottoNo("3"), LottoNo("4"), LottoNo("5"), LottoNo("5")))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
