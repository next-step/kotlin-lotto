package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.domain.model.LastWeekMatchLotto
import lotto.domain.model.Lotto
import lotto.domain.model.LottoCash

class LottoStoreTest : BehaviorSpec({
    given("로또를 구매할 수 있는 구입 금액이 주어지면") {
        val cash = 1000
        val lottoCash = LottoCash(cash)
        then("로또를 구매할 수 있다.") {
            LottoStore.isPurchasable(lottoCash) shouldBe true
        }
    }
    given("로또를 구매할 수 없는 구입 금액이 주어지면") {
        val cash = 500
        val lottoCash = LottoCash(cash)
        then("로또를 구매할 수 없다.") {
            LottoStore.isPurchasable(lottoCash) shouldBe false
        }
    }

    given("로또 구입 금액이 주어지고") {
        forAll(
            row(1000),
            row(2000),
            row(50000)
        ) { cash ->
            val lottoCash = LottoCash(cash)
            `when`("로또 1장의 가격이 1000원 이라고 하면") {
                val lottoPrice = 1000
                then("로또 구입 금액에 해당하는 로또를 자동 발급할 수 있다.") {
                    val lottos = LottoStore.purchaseLottosByAuto(lottoCash)
                    lottos.size shouldBe lottoCash.value / lottoPrice
                }
            }
        }
    }

    given("로또 번호와 지난주 당첨 번호가 주어지고") {
        val lottos = listOf(
            Lotto.valueOf(listOf(8, 21, 23, 41, 42, 43)),
            Lotto.valueOf(listOf(3, 5, 11, 16, 32, 38)),
            Lotto.valueOf(listOf(7, 11, 16, 35, 36, 44)),
            Lotto.valueOf(listOf(1, 3, 5, 14, 22, 45)),
        )
        val numbers = listOf(1, 3, 5, 11, 16, 32)
        val bonusNumber = 45
        val lastWeekMatchLotto = LastWeekMatchLotto.valueOf(numbers, bonusNumber)
        `when`("당첨 통계를 확인하면") {
            val result = LottoStore.checkMatchResult(lottos, lastWeekMatchLotto)
            then("결과의 수는 로또의 수와 같다.") {
                result.size shouldBe lottos.size
            }
        }
    }
})
