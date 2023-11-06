package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PrizeTest {

    @ParameterizedTest
    @CsvSource(
        "0, false", "1, false", "2, false", "3, false", "4, false", "5, false", "5, true", "6, false"
    )
    fun `lotto 리스트와 당첨번호, 보너스번호를 이용해 당첨결과를 집계한다`(matches: Int, hitBonus: Boolean) {
        val bonusNum = 7
        val winningNum = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val numbers = mutableListOf<Int>()

        // 테스트용 로또 생성. matches 만큼 당첨번호를 추가한다.
        if (hitBonus) numbers.add(bonusNum)
        (1..matches).forEach { numbers.add(it) }
        repeat(Lotto.NUMBER_NUM - numbers.size) { numbers.add(ILLEGAL_NUM) }

        // Lottos를 생성하고 result가 제대로 생성되었는지 확인한다.
        val lottos = Lottos(listOf(Lotto(numbers)))

        Prize.getResult(lottos, winningNum, bonusNum).forEach {
            if (matches < 3) {
                assertThat(it).isEqualTo(Prize.NO_PRIZE)
                return@forEach
            }

            assertThat(it.match).isEqualTo(matches)
            if (hitBonus) {
                assertThat(it).isEqualTo(Prize.SECOND)
            }
        }
    }

    companion object {
        const val ILLEGAL_NUM = 50
    }
}
