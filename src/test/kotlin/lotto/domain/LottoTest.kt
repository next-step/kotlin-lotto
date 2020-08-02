package lotto.domain

import lotto.domain.value.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTest {

    @Test
    fun getWinCount() {
        // 랜덤 주입 필요
        val winningNumber = List(6) { LottoNumber(it + 1) }
        val actual = Lotto().getWinCount(winningNumber)
        assertThat(actual).isBetween(1, 6)
    }
}
