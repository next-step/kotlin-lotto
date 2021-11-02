package domain.lotto.domain

import domain.lotto.error.DuplicateBonusBallNumberException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
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

    @ParameterizedTest(name = "당첨 로또 : {0}, 보너스볼: {1}")
    @CsvSource(
        value = [
            "1, 2, 3, 4, 5, 6:1", "1, 2, 3, 4, 5, 6:6",
            "40, 41, 42, 43, 44, 45:40", "40, 41, 42, 43, 44, 45: 45"
        ], delimiter = ':'
    )
    fun `로또 당첨 번호와 보너스 번호가 중복 되어서는 안 된다`(winningLotto: String, bonusBall: Int) {
        val exception = assertThrows<DuplicateBonusBallNumberException> {
            WinningLotto.from(winningLotto, bonusBall) { it.split(", ") }
        }

        assertThat(exception.message).isEqualTo("보너스 번호 %s 는 중복되었습니다.".format(bonusBall))
    }

    @ParameterizedTest(name = "당첨 로또 : {0}, 보너스볼: {1}")
    @CsvSource(
        value = [
            "1, 2, 3, 4, 5, 6:7:7, 8, 9, 10, 11, 12:true", "2, 3, 4, 5, 6, 7:1:8, 9, 10, 11, 12, 13:false",
            "40, 41, 42, 43, 44, 45:39:39, 38, 37, 36, 35, 34:true", "39, 40, 41, 42, 43, 44:45:39, 38, 37, 36, 35, 34:false"],
        delimiter = ':'
    )
    fun `보너스 번호가 포함되었는지 여부를 반환한다`(winningLotto: String, bonusBall: Int, lotto: String, expected: Boolean) {
        val winningLotto = WinningLotto.from(winningLotto, bonusBall) { it.split(", ") }
        val lotto = Lotto.of(lotto) { it.split(", ") }
        val actual = winningLotto.matchBonusBall(lotto)

        assertThat(actual).isEqualTo(expected)
    }
}
