package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class LottoNumberPackageTest {

    @ParameterizedTest
    @MethodSource("getInvalidSizeOfLottoNumbers")
    fun `번호를 6개 입력하지 않았을 경우 IllegalArgumentException이 발생한다`(numbers: List<LottoNumber>) {
        Assertions.assertThatThrownBy {
            LottoNumberPackage(numbers.toSet())
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    private fun getInvalidSizeOfLottoNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf(LottoNumber(1))),
            Arguments.of(listOf(LottoNumber(1),LottoNumber(2))),
            Arguments.of(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3))),
            Arguments.of(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4))),
            Arguments.of(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5))),
            Arguments.of(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6), LottoNumber(7)))
        )
    }

    @ParameterizedTest
    @MethodSource("getValidSizeOfLottoNumbers")
    fun `번호를 6개 입력 했을 경우 정상적으로 LottoNumberPackage가 생성된다`(numbers: List<LottoNumber>) {
        val lottoNumberPackage = LottoNumberPackage(numbers.toSet())

        assertThat(lottoNumberPackage).isNotNull
        assertThat(lottoNumberPackage.size()).isEqualTo(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT)
    }

    private fun getValidSizeOfLottoNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))
        )
    }
}
