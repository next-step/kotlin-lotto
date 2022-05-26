package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LottoWinningHandlerTest {

    @Test
    fun matchCount() {
        val issuedLottos = listOf(
            listOf(1,5,6,8,9,11),
            listOf(2,4,5,6,8,22),
            listOf(1,4,5,6,12,55),
        )
        val winningInfo = LottoWinningInfo("1,2,3,4,5,6")

        val result = LottoWinningHandler.matchCount(issuedLottos, winningInfo)
        assertThat(result.get(3)).isEqualTo(1)
        assertThat(result.get(4)).isEqualTo(2)
    }
}