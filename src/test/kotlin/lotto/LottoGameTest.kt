import lotto.Lotto
import lotto.LottoGame
import lotto.Rank
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
        assertThat(lottoGame.getLottoList(count).size).isEqualTo(count)
    }

    @DisplayName(value = "로또 결과")
    @ParameterizedTest
    @ValueSource(ints = [3, 4, 5, 6])
    fun result(count: Int) {
        val lottoList = listOf(Lotto.getAutoNumbers())
        val winningLotto = Lotto(lottoList.first().numbers.take(count).toSet())
        val result = lottoGame.result(lottoList, winningLotto, 0).toList()
        result.first().let { (rank, count) ->
            assertThat(rank.count).isEqualTo(count)
        }
    }

    @DisplayName(value = "로또 결과 - 보너스 볼 일치")
    @Test
    fun resultBonus() {
        val lottoList = listOf(Lotto.getAutoNumbers())
        val winningLotto = Lotto(lottoList.first().numbers.take(5).toSet())
        val bonus = lottoList.first().numbers.last()
        val result = lottoGame.result(lottoList, winningLotto, bonus).toList()
        assertThat(result.first().first).isEqualTo(Rank.SECOND)
    }

    @DisplayName(value = "로또 번호 범위 (1 ~ 45) 테스트")
    @Test
    fun rangeLottoNumbers() {
        Lotto.getAutoNumbers().numbers.forEach {
            assertThat(it).isIn(1..45)
        }
    }
}
