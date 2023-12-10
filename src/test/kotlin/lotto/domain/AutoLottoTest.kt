package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.winningpoint.WinningStatistics

class AutoLottoTest : FunSpec({
    test("로또 구입금액을 입력받으면 로또 수량이 결정된다") {
        // Given
        val input = 1000L

        // When
        val lotto = AutoLotto(input)

        // Then
        lotto.count shouldBe 1L
    }

    test("로또 구입금액 1500원을 입력받으면 로또 수량은 1개로 결정된다") {
        // Given
        val input = 1500L

        // When
        val lotto = AutoLotto(input)

        // Then
        lotto.count shouldBe 1L
    }

    test("로또 1장의 숫자는 1~45의 숫자가 아니면 exception") {
        shouldThrow<IllegalArgumentException> {
            LottoNumber.of(46)
        }
    }

    test("수익률은 총 수익금 / 총 구입금액 으로 계산한다") {
        // Given
        val input = 1000L
        val lottoNumber = (1..6).map { LottoNumber.of(it) }
        val lottos = Lottos(listOf(Lotto(lottoNumber)))
        val winningLotto = WinningLotto("1, 2, 3, 4, 5, 6", "7")

        // When
        val winningPrice = winningLotto.calculateTotalWinningPrice(lottos)
        val profitRate = WinningStatistics.getProfitRate(input, winningPrice)

        // Then
        profitRate shouldBe 200000.0
    }
})
