package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class BonusNumberTest {

    @ParameterizedTest
    @MethodSource("getBonusNumberDuplicatedWithWinningNumbers")
    fun `보너스번호 생성 시 당첨번호와 중복된 번호를 입력하면 IllegalArgumentException 이 발생한다`(bonusNumber: String, winningNumbers: List<Int>) {
        val winningNumberPackage = LottoNumberPackage(winningNumbers.map { LottoNumber[it] }.toSet())

        Assertions.assertThatThrownBy {
            BonusNumber.from(bonusNumber, winningNumberPackage)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    private fun getBonusNumberDuplicatedWithWinningNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of("1", listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of("2", listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of("3", listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of("4", listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of("5", listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of("6", listOf(1, 2, 3, 4, 5, 6)),
        )
    }

    @ParameterizedTest
    @MethodSource("getBonusNumberNotDuplicatedWithWinningNumbers")
    fun `보너스번호 생성 시 당첨번호와 중복되지 않는 번호를 입력하면 정상적으로 LottoNumber 객체가 생성된다`(bonusNumberInput: String, winningNumbers: List<Int>) {
        val winningNumberPackage = LottoNumberPackage(winningNumbers.map { LottoNumber[it] }.toSet())
        val bonusNumber = BonusNumber.from(bonusNumberInput, winningNumberPackage)

        assertThat(bonusNumber).isNotNull
        assertThat(bonusNumber.value).isEqualTo(bonusNumberInput.toInt())
    }

    private fun getBonusNumberNotDuplicatedWithWinningNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of("7", listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of("8", listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of("9", listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of("10", listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of("11", listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of("12", listOf(1, 2, 3, 4, 5, 6)),
        )
    }
}
