package lotto.model.number

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.TreeSet

internal class WinningNumbersTest {

    @ParameterizedTest
    @MethodSource("collectionProvider")
    fun `인자로 주어진 컬렉션이 변해도 WinningNumbers 는 변하지 말아야 한다`(numbers: TreeSet<WinningNumber>) {
        val lottoNumbers = WinningNumbersFactory.create(numbers)

        Assertions.assertThat(lottoNumbers.size).isEqualTo(6)
        numbers.add(WinningNumber.get(7))
        Assertions.assertThat(lottoNumbers.size).isEqualTo(6)
    }

    companion object {
        @JvmStatic
        fun collectionProvider(): List<Arguments> {
            return listOf(
                Arguments {
                    arrayOf(TreeSet((1..LottoNumbers.CANDIDATE_SIZE).map { WinningNumber.get(it) }))
                }
            )
        }
    }
}
