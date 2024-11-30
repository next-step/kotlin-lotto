package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class WinningMachineTest {
    @Test
    fun `당첨 번호와 로또 번호 일치 개수에 따라 상금 계산과 수익률을 구할 수 있다`() {
        val winningLotto = Lotto.create(listOf(1, 2, 3, 4, 5, 6))
        val lottos =
            listOf(
                Lotto.create(listOf(1, 2, 3, 4, 5, 6)),
                Lotto.create(listOf(1, 2, 3, 4, 5, 7)),
                Lotto.create(listOf(1, 2, 3, 4, 8, 9)),
                Lotto.create(listOf(1, 2, 3, 7, 8, 9)),
                Lotto.create(listOf(10, 11, 12, 13, 14, 15)),
            )

        val winningMachine = WinningMachine(winningLotto)
        val statistics = winningMachine.calculateStatistics(lottos)

        statistics.matchCount[6] shouldBe 1
        statistics.matchCount[5] shouldBe 1
        statistics.matchCount[4] shouldBe 1
        statistics.matchCount[3] shouldBe 1
        statistics.matchCount[0] shouldBe 1

        statistics.totalPrize shouldBe 20_0155_5000
        statistics.rate shouldBe 40_0311.0
    }

    @Test
    fun `수익률이 1 이하일 경우 1보다 작은 값으로 계산된다`() {
        val winningLotto = Lotto.create(listOf(1, 2, 3, 4, 5, 6))
        val lottos =
            listOf(
                Lotto.create(listOf(1, 2, 3, 7, 8, 9)),
                Lotto.create(listOf(6, 7, 8, 9, 10, 11)),
                Lotto.create(listOf(6, 7, 18, 19, 20, 21)),
                Lotto.create(listOf(10, 11, 12, 13, 14, 15)),
                Lotto.create(listOf(16, 17, 18, 19, 20, 21)),
                Lotto.create(listOf(20, 21, 22, 23, 24, 25)),
                Lotto.create(listOf(26, 27, 28, 29, 30, 31)),
                Lotto.create(listOf(30, 31, 32, 33, 34, 35)),
                Lotto.create(listOf(36, 37, 38, 39, 40, 41)),
                Lotto.create(listOf(40, 41, 42, 43, 44, 45)),
            )

        val winningMachine = WinningMachine(winningLotto)
        val statistics = winningMachine.calculateStatistics(lottos)

        statistics.totalPrize shouldBe 5000
        statistics.rate shouldBe 0.5
    }

    @Test
    fun `당첨 로또 번호와 일치하지 않을 경우 수익률이 0이 된다`() {
        val winningLotto = Lotto.create(listOf(1, 2, 3, 4, 5, 6))
        val lottos =
            listOf(
                Lotto.create(listOf(1, 2, 7, 8, 9, 10)),
                Lotto.create(listOf(6, 7, 8, 9, 10, 11)),
                Lotto.create(listOf(6, 7, 18, 19, 20, 21)),
                Lotto.create(listOf(10, 11, 12, 13, 14, 15)),
                Lotto.create(listOf(16, 17, 18, 19, 20, 21)),
                Lotto.create(listOf(20, 21, 22, 23, 24, 25)),
                Lotto.create(listOf(26, 27, 28, 29, 30, 31)),
                Lotto.create(listOf(30, 31, 32, 33, 34, 35)),
                Lotto.create(listOf(36, 37, 38, 39, 40, 41)),
                Lotto.create(listOf(40, 41, 42, 43, 44, 45)),
            )

        val winningMachine = WinningMachine(winningLotto)
        val statistics = winningMachine.calculateStatistics(lottos)

        statistics.totalPrize shouldBe 0
        statistics.rate shouldBe 0
    }
}
