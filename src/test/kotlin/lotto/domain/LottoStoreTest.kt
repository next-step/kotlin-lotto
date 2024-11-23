package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoStoreTest : StringSpec({
    val lottoNumberGenerator = RandomNumberGenerator()
    val lottoFactory = LottoFactory(lottoNumberGenerator)
    val sut = LottoStore(lottoFactory)

    "입력받은 금액만큼 로또를 생성한다" {
        val money = Money(14000)

        val actual = sut.sell(money)

        actual.quantity shouldBe 14
    }
})
