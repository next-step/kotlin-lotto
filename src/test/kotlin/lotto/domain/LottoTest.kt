package lotto.domain

import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LottoTest {

    @ParameterizedTest
    @MethodSource
    fun `숫자가 6개가 아닌 로또는 생성불가`(lottoNumbers: List<LottoNumber>) {
        assertThrows<IllegalArgumentException> { Lotto.create(lottoNumbers) }
            .shouldHaveMessage("로또 숫자가 6개가 아닌 로또는 생성할 수 없습니다.")
    }

    @ParameterizedTest
    @MethodSource
    fun `중복된 숫자를 가진 로또는 생성 불가`(lottoNumbers: List<LottoNumber>) {
        assertThrows<IllegalArgumentException> { Lotto.create(lottoNumbers) }
            .shouldHaveMessage("로또 숫자는 중복될 수 없습니다.")
    }

    companion object {
        @JvmStatic
        fun `숫자가 6개가 아닌 로또는 생성불가`(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                    ),
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
        fun `중복된 숫자를 가진 로또는 생성 불가`(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(1),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
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
