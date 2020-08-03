package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    @DisplayName("1 ~ 50 사이의 6개 중복되지 않는 숫자가 반환된다")
    fun `createLottoNumber`() {
        val diceRandom = DiceRandomMaker()
        val result = Lotto(diceRandom)
        assertThat(result.lottoNumber.size).isEqualTo(Lotto.MAKE_NUMBER_COUNT)
    }
}
