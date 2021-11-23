package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottosTest {
    @Test
    fun `로또 티켓들을 생성한다`() {
        val lotto1 = Lotto.of(1, 2, 3, 4, 5, 6)
        val lotto2 = Lotto.of(1, 2, 3, 4, 5, 7)
        val lottos = Lottos(listOf(lotto1, lotto2))
        assertAll(
            { assertThat(lottos.toList()).isEqualTo(listOf(lotto1, lotto2)) },
            { assertThat(lottos.count()).isEqualTo(2) },
            { assertThat(lottos.totalPrice()).isEqualTo(2000) },
        )
    }

    @Test
    fun `로또티켓 번호 맞춘 개수를 반환한다`() {
        val lottos = Lottos(
            listOf(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 7),
            )
        )
        val other = Lotto.of(1, 2, 3, 4, 5, 6)
        assertThat(lottos.matchCount(other)).isEqualTo(listOf(6, 5))
    }

    @ParameterizedTest
    @CsvSource("14,14000", "10,10000", "14,14999")
    fun `구입금액에 해당하는 로또 티켓들을 살 수 있다`(count: Int, value: Int) {
        val money = Money.of(value)
        val lottos = Lottos.from(money)
        assertThat(lottos.count()).isEqualTo(count)
    }

    @Test
    internal fun `구입금액이 1000원 이하면 로또 티켓을 살 수 없다`() {
        val money = Money.of(999)
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lottos.from(money) }
            .withMessage("지불 금액은 최소 금액(1000원) 이상이어야 합니다.")
    }
}
