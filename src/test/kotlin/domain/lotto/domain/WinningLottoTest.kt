package domain.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("당첨 로또(WinningLotto)")
class WinningLottoTest {

    @ParameterizedTest(name = "당첨 로또 : {0}, 보너스볼: {1}")
    @CsvSource(
        value = [
            "1, 2, 3, 4, 5, 6:7", "2, 3, 4, 5, 6, 7:1",
            "40, 41, 42, 43, 44, 45:39", "39, 40, 41, 42, 43, 44:45"], delimiter = ':'
    )
    fun `로또 당첨 번호와 보너스 번호를 통해 생성할 수 있다`(winningLotto: String, bonusBall: Int) {
        val winningLotto = WinningLotto.from(winningLotto, bonusBall) { it.split(", ") }

        assertAll(
            { assertThat(winningLotto).isNotNull },
            { assertThat(winningLotto).isExactlyInstanceOf(WinningLotto::class.java) },
        )
    }
}