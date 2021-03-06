package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottosTest {
    @Test
    fun `구매할 수 있는 로또 갯수를 인자로 주면, 해당 갯수만큼 Lotto를 가진 Lottos 객체가 생성된다`() {
        // given
        val lottoCount = 5

        // when
        val myLottos = Lottos(lottoCount)

        // then
        assertThat(myLottos.lottos.size).isEqualTo(5)
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 4, 5, 6])
    fun `당첨번호와 일치카운트를 인자로 주면, 해당 당첨번호와 일치카운트만큼 일치하는 로또 갯수를 반환한다`(checkCount: Int) {
        // given
        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 8, 9)),
                Lotto(listOf(1, 2, 3, 10, 11, 12))
            )
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val count = lottos.check(winningNumbers, checkCount)

        // then
        assertThat(count).isEqualTo(1)
    }
}