package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WinningLottoTest {
    @Test
    fun `당첨 티켓은 6개의 로또 번호로 생성된다`() {
        val winningLotto = WinningLotto()
        winningLotto.lottoNumbers.size shouldBe 6
    }

    @Test
    fun `당첨 티켓의 번호는 6개가 아니면 에러가 발생한다`() {
        shouldThrow<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4))
        }.also {
            it.message shouldBe "당첨 번호 입력이 유효하지 않습니다"
        }
    }

    @ParameterizedTest
    @MethodSource("generateWiningLotto")
    fun `로또 티켓이 당첨 티켓과 몇개가 일치하는지 확인 할 수 있다`(
        lottoTicket: LottoTicket,
        winningLotto: WinningLotto,
        count: Int,
    ) {
        val matchCount = winningLotto.calculateMatchCount(lottoTicket)
        matchCount shouldBe count
    }

    companion object {
        @JvmStatic
        fun generateWiningLotto() =
            listOf(
                Arguments.arguments(LottoTicket(listOf(1, 12, 13, 14, 15, 16)), WinningLotto(listOf(1, 2, 3, 4, 5, 6)), 1),
                Arguments.arguments(LottoTicket(listOf(1, 2, 13, 14, 15, 16)), WinningLotto(listOf(1, 2, 3, 4, 5, 6)), 2),
                Arguments.arguments(LottoTicket(listOf(1, 2, 3, 14, 15, 16)), WinningLotto(listOf(1, 2, 3, 4, 5, 6)), 3),
                Arguments.arguments(LottoTicket(listOf(1, 2, 3, 4, 15, 16)), WinningLotto(listOf(1, 2, 3, 4, 5, 6)), 4),
                Arguments.arguments(LottoTicket(listOf(1, 2, 3, 4, 5, 16)), WinningLotto(listOf(1, 2, 3, 4, 5, 6)), 5),
                Arguments.arguments(LottoTicket(listOf(1, 2, 3, 4, 5, 6)), WinningLotto(listOf(1, 2, 3, 4, 5, 6)), 6),
            )
    }
}
