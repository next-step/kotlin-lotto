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
        assertThat(lotto.isContainLottoNumber(1)).isEqualTo(true)
        assertThat(lotto.isContainLottoNumber(5)).isEqualTo(true)
        assertThat(lotto.isContainLottoNumber(8)).isEqualTo(false)
    }

    @Test
    fun `당첨 번호와 로또 번호가 일치한 양를 반환한다`() {
        lotto.processLotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.getContainLottoNumberSameCount(listOf(2, 9, 3, 11, 10, 1))).isEqualTo(3)
    }

    @Test
    fun `로또 번호와 당첨 번호가 3개 일치한다면 5000원으로 교환한다`() {
        assertThat(lotto.exchangeWinningMoney(3)).isEqualTo(5000)
    }
}
