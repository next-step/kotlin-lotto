package lotto.domain.value

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class WinLottoTest {
    @Test
    @Order(1)
    fun getFromIndex() {
        assertThat(WinLotto(0)).isEqualTo(WinLotto.ZERO)
        assertThat(WinLotto(1)).isEqualTo(WinLotto.ONE)
        assertThat(WinLotto(2)).isEqualTo(WinLotto.TWO)
        assertThat(WinLotto(3)).isEqualTo(WinLotto.THREE)
        assertThat(WinLotto(4)).isEqualTo(WinLotto.FOUR)
        assertThat(WinLotto(5)).isEqualTo(WinLotto.FIVE)
        assertThat(WinLotto(6)).isEqualTo(WinLotto.SIX)
    }

    @Test
    @Order(2)
    fun getCount() {
        assertThat(WinLotto.getCount(0)).isEqualTo(0)
    }

    @Test
    @Order(3)
    fun plusCount() {
        WinLotto.plusCount(0)
        assertThat(WinLotto.getCount(0)).isEqualTo(1)
    }

    @Test
    @Order(4)
    fun resultList() {
        val actual = WinLotto.resultList()
        val expect = listOf(WinLotto.THREE, WinLotto.FOUR, WinLotto.FIVE, WinLotto.SIX)
        assertThat(actual).isEqualTo(expect)
    }
}
