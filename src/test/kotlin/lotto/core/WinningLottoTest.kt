package lotto.core

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WinningLottoTest {
    @ParameterizedTest
    @MethodSource("provideParameters")
    fun `생성자에 잘못된 값 전달 시 오류를 확인한다`(
        numberList: List<LottoNumber>,
        bonusNumber: Int,
    ) {
        shouldThrow<IllegalArgumentException> {
            WinningLotto(numberList, LottoNumber(bonusNumber))
        }
    }

    companion object {
        @JvmStatic
        fun provideParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(transformLottoNumbers(listOf(1)), 1),
                Arguments.of(transformLottoNumbers(listOf(1, 2, 3)), 1),
                Arguments.of(transformLottoNumbers(listOf(1, 2, 3, 4, 5, 45, 3)), 45),
            )
        }

        @JvmStatic
        fun transformLottoNumbers(numbers: List<Int>): List<LottoNumber> {
            return numbers.map { LottoNumber(it) }
        }
    }
}
