package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryWinningTypesTest {

    @Test
    fun `로또게임 결과로 상금타입을 찾을 수 있다`() {
        val lottoGameResult = LottoGameResult(LottoHit(5), BonusAble(true))
        val expected = LotteryWinningTypes.FiveWithBonus
        val actual = LotteryWinningTypes.findTypeByLottoGameResult(lottoGameResult)
        assertThat(actual).isEqualTo(expected)
    }
}
