package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.LottoGame

internal class LottoGameTest : BehaviorSpec({

    Given("LottoGame") {
        When("구입 금액이 로또 단위가격 단위이면") {
            val lottoPrices = listOf(1000L, 20000, 345000)
            Then("정상적으로 LottoGame 생성") {
                val actual = lottoPrices.map { LottoGame(lottoPrice = it) }
                actual.forAll { lottoGame -> lottoGame.lottoPrice % LottoGame.LOTTO_PRICE shouldBe 0 }
            }
        }

        When("구입 금액이 로또 단위가격이 아니면") {
            val lottoPrices = listOf(1100L, 20200, 34500)
            Then("IllegalArgumentException 발생") {
                lottoPrices.forAll { lottoPrice ->
                    shouldThrow<IllegalArgumentException> { LottoGame(lottoPrice = lottoPrice) }
                }
            }
        }

        When("구입 금액을 입력하면") {
            val lottoPrices = listOf(1000L, 20000, 345000)
            Then("(구입 금액 / 로또 가격)만큼 로또 생성") {
                val actual = lottoPrices.map { LottoGame(lottoPrice = it) }
                actual.forAll { lottoGame ->
                    lottoGame.lottoList.lottos.size shouldBe lottoGame.lottoPrice / LottoGame.LOTTO_PRICE
                }
            }
        }
    }
})
