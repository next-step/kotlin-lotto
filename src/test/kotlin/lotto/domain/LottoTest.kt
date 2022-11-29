package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `로또는 검증된 로또 객체만 생성된다`() {
        assertThrows<IllegalArgumentException> { Lotto.of(listOf(1, 2, 3, 4, 5)) }
    }

    @Test
    fun `우승로또와 비교해서 매치된 숫자개수를 반환합니다`() {
        val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 8))

        assertThat(lotto.matchNumberWith(winningLotto)).isEqualTo(5)
    }
}
