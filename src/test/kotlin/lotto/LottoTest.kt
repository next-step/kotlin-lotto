package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또는 개당 1000원이다`() {
        // given
        val lottos = Lottos.buy(1000)

        // when
        val purchaseLottos = lottos.toList()

        // then
        assertThat(purchaseLottos.size).isEqualTo(1)
    }

    @Test
    fun `로또는 6개 숫자로 이루어져 있다`() {
        // given
        val lotto = Lotto(lottoNumber = LottoNumber(listOf(1, 2, 3, 4, 5, 6)))

        // then
        assertThat(lotto.toNumberList().size).isEqualTo(6)
    }

    @Test
    fun `로또가 6개의 숫자로 이루어 지지 않았다면 에러`() {
        // given
        val actual = runCatching { Lotto(lottoNumber = LottoNumber(listOf(1, 2, 3, 4, 5, 6, 7))) }.exceptionOrNull()

        // then
        assertThat(actual).hasMessageContaining("숫자가 6개가 들어와야 합니다.")
    }

    @Test
    fun `로또 번호에는 중복 된 숫자로 이루어질 수 없다`() {
        // given
        val actual = runCatching { Lotto(lottoNumber = LottoNumber(listOf(1, 2, 3, 4, 6, 6))) }.exceptionOrNull()

        // then
        assertThat(actual).hasMessageContaining("중복 된 숫자는 들어올 수 없습니다.")
    }

    @Test
    fun `로또는 여러개 살 수 있다`() {
        // given
        val lottos = Lottos.buy(14000)

        // when
        val purchaseLottos = lottos.toList()

        // then
        assertThat(purchaseLottos.size).isEqualTo(14)
    }
}
