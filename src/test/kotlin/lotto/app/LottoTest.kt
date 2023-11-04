package lotto.app

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({
    "구매할 Game 의 수를 입력받아 로또 Game 을 발급해야 한다" {
        val actual = Lotto.transaction(10)
        actual.games shouldHaveSize 10
    }

    "구매할 로또 Game 하나의 가격은 1000 이다"
        Lotto.priceOfGame() shouldBe 1000
 })
