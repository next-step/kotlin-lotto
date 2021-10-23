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
    fun `번호를 6개 입력하지 않았을 경우 IllegalArgumentException이 발생한다`(numbers: List<Int>) {
        Assertions.assertThatThrownBy {
            LottoNumberPackage(numbers.map { LottoNumber(it) }.toSet())
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    private fun getInvalidSizeOfLottoNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf(1)),
            Arguments.of(listOf(1, 2)),
            Arguments.of(listOf(1, 2, 3)),
            Arguments.of(listOf(1, 2, 3, 4)),
            Arguments.of(listOf(1, 2, 3, 4, 5)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7))
        )
    }

    @ParameterizedTest
    @MethodSource("getValidSizeOfLottoNumbers")
    fun `번호를 6개 입력 했을 경우 정상적으로 LottoNumberPackage가 생성된다`(numbers: List<Int>) {
        val lottoNumberPackage = LottoNumberPackage(numbers.map { LottoNumber(it) }.toSet())

        assertThat(lottoNumberPackage).isNotNull
        assertThat(lottoNumberPackage.size()).isEqualTo(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT)
    }

    private fun getValidSizeOfLottoNumbers(): Stream<Arguments> {
        return Stream.of(Arguments.of(listOf(1, 2, 3, 4, 5, 6)))
    }

    @ParameterizedTest
    @MethodSource("getUnsortedLottoNumbers")
    fun `정렬 되지 않은 번호번호로 LottoNumberPackage 를 생성한 후 getSortedNumbers()를 호출하면 정렬된 번호를 얻을 수 있다`(numbers: List<Int>) {
        val lottoNumberPackage = LottoNumberPackage(numbers.map { LottoNumber(it) }.toSet())

        assertThat(lottoNumberPackage).isNotNull
        assertThat(lottoNumberPackage.size()).isEqualTo(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT)
        assertThat(lottoNumberPackage.getSortedNumbers()).isEqualTo(numbers.toSortedSet(compareBy { it }))
    }

    private fun getUnsortedLottoNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf(2, 4, 5, 1, 6, 3)),
            Arguments.of(listOf(43, 25, 17, 9, 33, 29))
        )
    }
}
