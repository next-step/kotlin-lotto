package lotto.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResultLottoTest {
    @Test
    fun getFromIndex() {
        assertThat(ResultLotto.getFromIndex(0)).isEqualTo(ResultLotto.ZERO)
        assertThat(ResultLotto.getFromIndex(1)).isEqualTo(ResultLotto.ONE)
        assertThat(ResultLotto.getFromIndex(2)).isEqualTo(ResultLotto.TWO)
        assertThat(ResultLotto.getFromIndex(3)).isEqualTo(ResultLotto.THREE)
        assertThat(ResultLotto.getFromIndex(4)).isEqualTo(ResultLotto.FOUR)
        assertThat(ResultLotto.getFromIndex(5)).isEqualTo(ResultLotto.FIVE)
        assertThat(ResultLotto.getFromIndex(6)).isEqualTo(ResultLotto.SIX)
    }

    @Test
    fun getCount() {
        assertThat(ResultLotto.getCount(0)).isEqualTo(0)
    }

    @Test
    fun plusCount() {
        ResultLotto.plusCount(0)
        assertThat(ResultLotto.getCount(0)).isEqualTo(1)
    }

    @Test
    fun resultList() {
        val actual = ResultLotto.resultList()
        val expect = listOf(ResultLotto.THREE, ResultLotto.FOUR, ResultLotto.FIVE, ResultLotto.SIX)
        assertThat(actual).isEqualTo(expect)
    }
}
