package lotto.domain

import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LottoTest {

    @MethodSource
    @ParameterizedTest
    fun notSixNumberLottos(lottoNumbers: List<LottoNumber>) {
        assertThrows<IllegalArgumentException> { Lotto.create(lottoNumbers) }
            .shouldHaveMessage("로또 숫자가 6개가 아닌 로또는 생성할 수 없습니다.")
    }

    @MethodSource
    @ParameterizedTest
    fun duplicatedNumberLottos(lottoNumbers: List<LottoNumber>) {
        assertThrows<IllegalArgumentException> { Lotto.create(lottoNumbers) }
            .shouldHaveMessage("로또 숫자는 중복될 수 없습니다.")
    }

    companion object {
        @JvmStatic
        fun notSixNumberLottos(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                    )
                ),
                Arguments.arguments(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                        LottoNumber(7),
                    )
                )
            )
        }

        @JvmStatic
        fun duplicatedNumberLottos(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(1),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    )
                ),
                Arguments.arguments(
                    listOf(
                        LottoNumber(6),
                        LottoNumber(6),
                        LottoNumber(6),
                        LottoNumber(6),
                        LottoNumber(6),
                        LottoNumber(6),
                    )
                )
            )
        }
    }
}
