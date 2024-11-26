package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class UserTest {
    @Test
    fun `구입금액만큼 자동 구매 가능`() {
        val initialAmount = Amount(3000) // 사용자가 보유한 금액
        val user = User(initialAmount)
        val expectedLottos =
            Lottos(
                listOf(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto(listOf(7, 8, 9, 10, 11, 12)),
                    Lotto(listOf(13, 14, 15, 16, 17, 18)),
                ),
            )

        val autoMachine: (Amount) -> Lottos = { _ -> expectedLottos }
        user.buyLotto(autoMachine)

        assertAll(
            { assertThat(user.totalLottos).isEqualTo(expectedLottos) },
            { assertThat(user.totalLottoSize).isEqualTo(3) },
        )
    }
//
//    @ParameterizedTest
//    @MethodSource("rankTestData")
//    fun `ranks 를 통해 당첨금액을 계산한다`(
//        winningNumbers: Lotto,
//        userLottos: Lottos,
//        bonusNumber: Int,
//        expectedRank: Rank,
//    ) {
//        val user = User(Amount(1000))
//        user.buyLotto { userLottos }
//
//        val actual: LottoStatistics = user.statistics(winningNumbers, LottoNumber(bonusNumber))
//
//        assertThat(actual.machRankCount(expectedRank)).isEqualTo(1)
//    }
//
//    companion object {
//        @JvmStatic
//        fun rankTestData(): Stream<Arguments> =
//            Stream.of(
//                Arguments.of(
//                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
//                    Lottos(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))),
//                    7,
//                    Rank.FIRST,
//                ),
//                Arguments.of(
//                    Lotto(listOf(1, 2, 3, 4, 5, 10)),
//                    Lottos(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))),
//                    10,
//                    Rank.SECOND,
//                ),
//                Arguments.of(
//                    Lotto(listOf(1, 2, 3, 4, 5, 10)),
//                    Lottos(listOf(Lotto(listOf(1, 2, 3, 4, 5, 20)))),
//                    45,
//                    Rank.THIRD,
//                ),
//                Arguments.of(
//                    Lotto(listOf(1, 2, 3, 4, 11, 13)),
//                    Lottos(listOf(Lotto(listOf(1, 2, 3, 4, 20, 30)))),
//                    5,
//                    Rank.FOURTH,
//                ),
//                Arguments.of(
//                    Lotto(listOf(1, 2, 3, 10, 11, 12)),
//                    Lottos(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))),
//                    5,
//                    Rank.FIFTH,
//                ),
//                Arguments.of(
//                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
//                    Lottos(listOf(Lotto(listOf(1, 2, 10, 11, 12, 13)))),
//                    5,
//                    Rank.MISS,
//                ),
//            )
//    }
}
