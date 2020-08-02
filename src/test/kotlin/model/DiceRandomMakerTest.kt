package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DiceRandomMakerTest {
    @Test
    fun `crateRandomNumber`() {
        val diceRandomMaker = DiceRandomMaker()
        assertThat(diceRandomMaker.diceList.size).isEqualTo(diceRandomMaker.diceList.distinct().size)
    }
}
