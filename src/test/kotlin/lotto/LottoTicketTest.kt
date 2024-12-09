package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoTicketTest {
    @ParameterizedTest
    @MethodSource("providedDuplicationNumbers")
    fun `로또 티켓은 중복된 번호로 생성되면 예외가 발생한다`(numbers: List<Int>) {
        shouldThrow<IllegalArgumentException> {
            LottoTicket(numbers)
        }.also {
            it.message shouldBe "로또 티켓 번호가 잘못 입력되었습니다"
        }
    }

    @ParameterizedTest
    @MethodSource("providedWrongCountOfNumbers")
    fun `로또 티켓 번호는 6개가 아니면 예외가 발생한다`(numbers: List<Int>) {
        shouldThrow<IllegalArgumentException> {
            LottoTicket(numbers)
        }.also {
            it.message shouldBe "로또 티켓 번호가 잘못 입력되었습니다"
        }
    }

    @Test
    fun `로또 티켓을 생성하면 6개의 번호가 들어있다`() {
        val lottoTicket = LottoTicket.generateLottoNumber()
        lottoTicket.lottoNumbers.size shouldBe 6
    }

    companion object {
        @JvmStatic
        fun providedDuplicationNumbers() =
            listOf(
                Arguments.arguments(listOf(1, 1, 2, 3, 4, 5)),
                Arguments.arguments(listOf(5, 5, 12, 13, 34, 35)),
                Arguments.arguments(listOf(11, 19, 24, 33, 44, 44)),
            )

        @JvmStatic
        fun providedWrongCountOfNumbers() =
            listOf(
                Arguments.arguments(listOf(1, 2, 3, 4, 5, 6, 7)),
                Arguments.arguments(listOf(3, 5, 7, 8, 9)),
                Arguments.arguments(listOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6)),
            )
    }
}