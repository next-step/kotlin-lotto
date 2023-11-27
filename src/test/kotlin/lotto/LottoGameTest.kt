package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoGameTest {
    private var lottoGame: LottoGame = LottoGame()

    @DisplayName(value = "구입 금액에 해당하는 로또 개수 결과 출력")
    @ParameterizedTest
    @ValueSource(ints = [14000])
    fun getLottoCount(count: Int) {
        assertThat(lottoGame.getLottoCount(count)).isEqualTo(14)
    }

    @DisplayName(value = "로또 발급")
    @ParameterizedTest
    @ValueSource(ints = [1])
    fun start(count: Int) {
        assertThat(lottoGame.getLottoList(count).size).isEqualTo(count)
    }

    @DisplayName(value = "로또 결과")
    @ParameterizedTest
    @ValueSource(ints = [3, 4, 5, 6])
    fun result(count: Int) {
        val lottoList = listOf(Lotto.of())
        val lastLotto = Lotto(lottoList.first().numbers.take(count).toSet())
        val result = lottoGame.result(lottoList, lastLotto)
        LottoResult.findByMatchCount(count)?.let {
            assertThat(result.first()?.matchResult).isEqualTo(it.matchResult)
        }
    }
}
