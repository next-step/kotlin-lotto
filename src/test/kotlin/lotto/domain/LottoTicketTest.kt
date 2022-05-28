package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("로또 티켓")
internal class LottoTicketTest {

    @ParameterizedTest(name = "로또 번호 {0}")
    @MethodSource("정상 범위 6개")
    fun `1 ~ 45 사이의 정상 범위 6개 번호로 티켓 생성`(numbers: List<Int>) {
        val lottoTicket = LottoTicket(numbers)
        assertThat(lottoTicket.lottoNumbers).hasSize(numbers.size)
    }

    @ParameterizedTest(name = "로또 번호 {0}")
    @MethodSource("범위 외 6개")
    fun `1 ~ 45 이외의 범위로 6개 숫자 생성시 예외 발생`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> { LottoTicket(numbers) }
    }

    @ParameterizedTest(name = "로또 번호 {0}")
    @MethodSource("중복되는 숫자")
    fun `중복 숫자 생성시 예외 발생`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> { LottoTicket(numbers) }
    }

    @ParameterizedTest(name = "로또 번호 {0}")
    @MethodSource("갯수가 6개보다 작거나 큰 경우")
    fun `6개가 아닌 경우 예외 발생`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> { LottoTicket(numbers) }
    }

    companion object {
        @JvmStatic
        fun `정상 범위 6개`() = listOf(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of(listOf(44, 11, 2, 33, 15, 45)),
        )

        @JvmStatic
        fun `범위 외 6개`() = listOf(
            Arguments.of(listOf(-1, 2, 3, 4, 5, 6, 7)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 8, 49)),
        )

        @JvmStatic
        fun `중복되는 숫자`() = listOf(
            Arguments.of(listOf(1, 1, 1, 1, 1, 1)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 5)),
        )

        @JvmStatic
        fun `갯수가 6개보다 작거나 큰 경우`() = listOf(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7)),
            Arguments.of(listOf(1, 2, 3, 4, 5)),
        )
    }
}
