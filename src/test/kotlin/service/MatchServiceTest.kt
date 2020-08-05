package service

import model.DiceRandom
import model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MatchServiceTest {
    @Test
    @DisplayName("매칭 개수와 당첨 수를 반환한다")
    fun `prizeList`() {
        val prize = listOf<Int>(1, 2, 3, 4, 5, 6)
        val diceRandom = object : DiceRandom {
            override val diceList: List<Int>
                get() = listOf(1, 2, 3, 4, 5, 9)
        }
        val diceRandom2 = object : DiceRandom {
            override val diceList: List<Int>
                get() = listOf(1, 2, 3, 4, 8, 9)
        }
        val lottoList = listOf<Lotto>(Lotto(diceRandom), Lotto(diceRandom2))
        val matchService = MatchService(prize, lottoList)
        assertThat(matchService.prizeList).isNotEmpty
    }
}
