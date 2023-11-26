import lotto.Lotto
import lotto.LottoGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
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
        assertThat(lottoGame.start(count).size).isEqualTo(count)
    }

    @DisplayName(value = "로또 발급")
    @Test
    fun result() {
        val lottoList = listOf(Lotto(listOf(1, 2, 3, 7, 8, 9)))
        val lastNumbers = listOf(1, 2, 3, 4, 5, 6)
        lottoGame.match(lottoList, lastNumbers)
        assertThat(lottoList.first().matchCount).isEqualTo(3)
    }
}
