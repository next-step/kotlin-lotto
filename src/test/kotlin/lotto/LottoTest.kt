package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoTest {
    private lateinit var lotto: Lotto

    @BeforeEach
    fun setup() {
        lotto = Lotto()
    }

    @Test
    fun `로또가 발행될 때 번호가 발급된다`() {
        lotto.processLotto(listOf(1, 1, 1, 1, 1, 1))
        assertThat(lotto.numbers.size).isEqualTo(6)
        assertThat(lotto.numbers[1]).isNotEqualTo(0)
    }

    @Test
    fun `당첨 번호가 로또 번호들에 포함되어있다면 true를 반환한다`() {
        lotto.processLotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.checkContainLottoNumber(1)).isEqualTo(true)
        assertThat(lotto.checkContainLottoNumber(5)).isEqualTo(true)
        assertThat(lotto.checkContainLottoNumber(8)).isEqualTo(false)
    }
}
