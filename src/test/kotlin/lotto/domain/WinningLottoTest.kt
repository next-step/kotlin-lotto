package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.Test

class WinningLottoTest {
    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    fun `당첨 번호와 일치하는 개수를 비교 할 수 있다`(
        numbers: Set<LottoNumber>,
        matchCount: Int,
    ) {
        val winningLotto = WinningLotto(LottoTicket.from(setOf(1, 2, 3, 4, 5, 6)), LottoNumber.from(7))
        val count = winningLotto.calculateMatchCount(numbers)
        count shouldBe matchCount
    }

    @Test
    fun `보너스 번호는 로또 티켓의 번호와 중복될 수 없다`() {
        val lottoTicket = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber(6)
        shouldThrow<IllegalArgumentException> {
            WinningLotto(lottoTicket, bonusNumber)
        }.also {
            it.message shouldBe "보너스 번호는 로또 티켓의 번호와 중복될 수 없습니다"
        }
    }

    companion object {
        @JvmStatic
        fun provideLottoNumbers() =
            listOf(
                Arguments.arguments(listOf(1, 12, 13, 14, 15, 16).map { LottoNumber(it) }.toSet(), 1),
                Arguments.arguments(listOf(1, 2, 13, 14, 15, 16).map { LottoNumber(it) }.toSet(), 2),
                Arguments.arguments(listOf(1, 2, 3, 14, 15, 16).map { LottoNumber(it) }.toSet(), 3),
                Arguments.arguments(listOf(1, 2, 3, 4, 15, 16).map { LottoNumber(it) }.toSet(), 4),
                Arguments.arguments(listOf(1, 2, 3, 4, 5, 16).map { LottoNumber(it) }.toSet(), 5),
                Arguments.arguments(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet(), 6),
            )
    }
}
