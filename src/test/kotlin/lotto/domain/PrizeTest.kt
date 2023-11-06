package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PrizeTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6])
    fun `lotto 리스트와 당첨번호를 이용해 결과정보를 생성한다`(matches: Int) {
        val numbers = mutableListOf<Int>()

        // 테스트용 로또 생성. matches 만큼 당첨번호를 추가한다.
        (1..matches).forEach { numbers.add(it) }
        repeat(Lotto.NUMBER_NUM - matches) { numbers.add(ILLEGAL_NUM) }

        // Lottos를 생성하고 result가 제대로 생성되었는지 확인한다.
        val lottos = Lottos(listOf(Lotto(numbers)))
        val winningNum = Lotto(listOf(1, 2, 3, 4, 5, 6))
        Prize.getResult(lottos, winningNum).let {
            assertThat(Prize.countResult(it, matches)).isEqualTo(1)
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

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6])
    fun `당첨 등급 카운트`(matches: Int) {
        // 검증에 쓸 result 리스트 생성
        val result = mutableListOf(Prize.FIRST, Prize.SECOND, Prize.THIRD, Prize.FOURTH, Prize.NO_PRIZE)

        // 상금 카운트 검증
        assertThat(Prize.countResult(result, matches)).isEqualTo(1)
    }

    companion object {
        const val ILLEGAL_NUM = 50
    }
}
