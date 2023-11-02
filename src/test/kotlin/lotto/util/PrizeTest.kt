package lotto.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

const val ILLEGAL_NUM = 50
class PrizeTest {

    @Test
    fun `lotto 리스트와 당첨번호를 이용해 결과정보를 생성한다`() {
        val winningNum = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumbers = listOf(
            listOf(1, ILLEGAL_NUM, ILLEGAL_NUM, ILLEGAL_NUM, ILLEGAL_NUM, ILLEGAL_NUM),
            listOf(1, 2, ILLEGAL_NUM, ILLEGAL_NUM, ILLEGAL_NUM, ILLEGAL_NUM),
            listOf(1, 2, 3, ILLEGAL_NUM, ILLEGAL_NUM, ILLEGAL_NUM),
            listOf(1, 2, 3, 4, ILLEGAL_NUM, ILLEGAL_NUM),
            listOf(1, 2, 3, 4, 5, ILLEGAL_NUM),
            listOf(1, 2, 3, 4, 5, 6)
        )

        // 1~4등상이 하나씩, 순위권 외 항목이 2개 존재
        Prize.getResult(lottoNumbers, winningNum).let {
            assertThat(Prize.countResult(it, 6)).isEqualTo(1)
            assertThat(Prize.countResult(it, 5)).isEqualTo(1)
            assertThat(Prize.countResult(it, 4)).isEqualTo(1)
            assertThat(Prize.countResult(it, 3)).isEqualTo(1)
            assertThat(Prize.countResult(it, -1)).isEqualTo(2)
        }
    }

    @Test
    fun `일치 횟수에 해당하는 Prize 반환`() {
        assertThat(Prize.getPrize(6)).isEqualTo(Prize.FIRST)
        assertThat(Prize.getPrize(5)).isEqualTo(Prize.SECOND)
        assertThat(Prize.getPrize(4)).isEqualTo(Prize.THIRD)
        assertThat(Prize.getPrize(3)).isEqualTo(Prize.FOURTH)
        assertThat(Prize.getPrize(2)).isEqualTo(Prize.NO_PRIZE)
        assertThat(Prize.getPrize(1)).isEqualTo(Prize.NO_PRIZE)
        assertThat(Prize.getPrize(0)).isEqualTo(Prize.NO_PRIZE)
    }

    @Test
    fun `당첨 등급 카운트`() {
        val result = listOf(Prize.FIRST, Prize.SECOND, Prize.THIRD, Prize.FOURTH, Prize.NO_PRIZE, Prize.NO_PRIZE)
        assertThat(Prize.countResult(result, 6)).isEqualTo(1)
        assertThat(Prize.countResult(result, 5)).isEqualTo(1)
        assertThat(Prize.countResult(result, 4)).isEqualTo(1)
        assertThat(Prize.countResult(result, 3)).isEqualTo(1)
        assertThat(Prize.countResult(result, -1)).isEqualTo(2)
    }
}
