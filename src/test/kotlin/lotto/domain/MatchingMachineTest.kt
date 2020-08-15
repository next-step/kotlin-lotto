package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class MatchingMachineTest {

    @ParameterizedTest
    @MethodSource("generateMatchingTestData")
    fun `구입한 로또 번호와 당첨 번호, 보너스 번호가 주어지면 매칭 결과를 알려준다`(
        lotto: Set<LottoNumber>,
        winningNumbers: Set<LottoNumber>,
        bonusNumber: LottoNumber,
        PrizeResult: PrizeResult
    ) {
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        val matched = MatchingMachine.match(lotto, winningLotto)

        assertThat(matched).isEqualTo(PrizeResult)
    }

    companion object {
        @JvmStatic
        fun generateMatchingTestData(): List<Arguments> {
            return listOf(
                Arguments.of(
                    setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.get(it) }.toSet(),
                    setOf(1, 2, 3, 8, 9, 10).map { LottoNumber.get(it) }.toSet(),
                    LottoNumber.get(44),
                    PrizeResult.THREE_MATCH
                ),
                Arguments.of(
                    setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.get(it) }.toSet(),
                    setOf(1, 2, 3, 4, 5, 7).map { LottoNumber.get(it) }.toSet(),
                    LottoNumber.get(6),
                    PrizeResult.BONUS_MATCH
                )
            )
        }
    }
}
