package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UserTest {
    @Test
    fun `구입금액만큼 자동 구매 가능`() {
        val initialAmount = Amount(3_000) // 사용자가 보유한 금액
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
        user.buyAutoLotto(autoMachine)

        assertAll(
            { assertThat(user.totalLottos).isEqualTo(expectedLottos) },
            { assertThat(user.totalLottoSize).isEqualTo(3) },
        )
    }

    @Test
    fun `수동 구매 가능`() {
        val initialAmount = Amount(3_000) // 사용자가 보유한 금액
        val user = User(initialAmount)
        val expectedLottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(7, 8, 9, 10, 11, 12)),
                Lotto(listOf(13, 14, 15, 16, 17, 18)),
            )
        )

        user.buyManualLottos(expectedLottos)

        assertAll(
            { assertThat(user.totalLottos).isEqualTo(expectedLottos) },
            { assertThat(user.totalLottoSize).isEqualTo(3) },
        )
    }


    @Test
    fun `금액 보다 수동 수량이 많으면 예외 발생`() {
        val initialAmount = Amount(1_000) // 사용자가 보유한 금액
        val user = User(initialAmount)
        val expectedLottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(7, 8, 9, 10, 11, 12)),
                Lotto(listOf(13, 14, 15, 16, 17, 18)),
            )
        )

        assertAll(
            { assertThatIllegalArgumentException().isThrownBy { user.buyManualLottos(expectedLottos) } },
            { assertThat(user.totalLottos).isEqualTo(Lottos(emptyList())) },
            { assertThat(user.totalLottoSize).isEqualTo(0) },
        )
    }

    @Test
    fun `잔여 금액 로또 모두 자동 구매`() {
        val initialAmount = Amount(3_000) // 사용자가 보유한 금액
        val user = User(initialAmount)
        val manualLottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(7, 8, 9, 10, 11, 12)),
            )
        )
        val autoLottos = Lottos(
            listOf(
                Lotto(listOf(13, 14, 15, 16, 17, 18)),
            )
        )
        user.buyManualLottos(manualLottos)

        val autoMachine: (Amount) -> Lottos = { _ -> autoLottos }
        user.buyAutoLotto(autoMachine)

        assertAll(
            { assertThat(user.totalLottoSize).isEqualTo(3) },
            { assertThat(user.totalBuyAmount).isEqualTo(Amount(3_000)) },
        )
    }

    @Test
    fun `수동 번호와 자동 번호 조합 하여 최종 로또 목록을 알 수 있다`() {
        val initialAmount = Amount(3_000) // 사용자가 보유한 금액
        val user = User(initialAmount)
        val manualLottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(7, 8, 9, 10, 11, 12)),
            )
        )
        val autoLottos = Lottos(
            listOf(
                Lotto(listOf(13, 14, 15, 16, 17, 18)),
            )
        )
        user.buyManualLottos(manualLottos)

        val autoMachine: (Amount) -> Lottos = { _ -> autoLottos }
        user.buyAutoLotto(autoMachine)

        val expectedLottos = manualLottos.merge(autoLottos)
        assertAll(
            { assertThat(user.totalLottos).isEqualTo(expectedLottos) },
            { assertThat(user.totalLottoSize).isEqualTo(3) },
        )
    }

    @Test
    fun `수동 구매 수량과 자동 구매수량을 알 수 있다`() {
        val initialAmount = Amount(3_000) // 사용자가 보유한 금액
        val user = User(initialAmount)
        val manualLottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(7, 8, 9, 10, 11, 12)),
            )
        )
        val autoLottos = Lottos(
            listOf(
                Lotto(listOf(13, 14, 15, 16, 17, 18)),
            )
        )
        user.buyManualLottos(manualLottos)

        val autoMachine: (Amount) -> Lottos = { _ -> autoLottos }
        user.buyAutoLotto(autoMachine)

        assertAll(
            { assertThat(user.manualLottoSize).isEqualTo(2) },
            { assertThat(user.autoLottoSize).isEqualTo(1) },
        )
    }
}
