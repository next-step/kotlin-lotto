package lotto

import lotto.domain.LotteryWinningTypes
import lotto.domain.LottoGameResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryWinningTypesTest {

    @Test
    fun `로또게임 결과로 상금타입을 찾을 수 있다`() {
        val lottoGameResult = LottoGameResult(5, true)
        val expected = LotteryWinningTypes.FiveWithBonus
        val actual = LotteryWinningTypes.findTypeByLottoGameResult(lottoGameResult)
        assertThat(actual).isEqualTo(expected)
    }
}
