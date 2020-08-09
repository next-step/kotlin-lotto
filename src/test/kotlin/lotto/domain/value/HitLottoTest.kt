package lotto.domain.value

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class HitLottoTest {

    @BeforeEach
    fun setUp() {
        HitLotto.resetCount()
    }

    @Test
    fun plusCount() {
        val actual = HitLotto.SIX.plusCount()
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun toStringTest() {
        val five = HitLotto.FIVE
        five.plusCount()

        val actual = HitLotto.FIVE.toString()
        val expect = "5개 일치 (1500000원)- 1개\n"
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun invoke() {
        assertThat(HitLotto(0)).isEqualTo(HitLotto.ZERO)
        assertThat(HitLotto(1)).isEqualTo(HitLotto.ONE)
        assertThat(HitLotto(2)).isEqualTo(HitLotto.TWO)
        assertThat(HitLotto(3)).isEqualTo(HitLotto.THREE)
        assertThat(HitLotto(4)).isEqualTo(HitLotto.FOUR)
        assertThat(HitLotto(5)).isEqualTo(HitLotto.FIVE)
        assertThat(HitLotto(6)).isEqualTo(HitLotto.SIX)
    }

    @Test
    fun resultList() {
        val actual = HitLotto.resultList()
        val expect = listOf(HitLotto.THREE, HitLotto.FOUR, HitLotto.FIVE, HitLotto.SIX)
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun totalIncome() {
        HitLotto.THREE.plusCount()
        HitLotto.FOUR.plusCount()
        HitLotto.FIVE.plusCount()
        HitLotto.SIX.plusCount()
        val actual = HitLotto.totalIncome()
        val expect = HitLotto.THREE.money + HitLotto.FOUR.money + HitLotto.FIVE.money + HitLotto.SIX.money
        assertThat(actual).isEqualTo(expect)
    }
}
