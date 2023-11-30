package lotto.model

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoGameTest : StringSpec({

    "6개의 숫자만을 가져야한다" {
        shouldNotThrow<IllegalArgumentException> {
            LottoGame(11, 22, 33, 4, 5, 6)
        }
    }

    "6개보다 부족하거나, 초과하면 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            LottoGame(11, 22, 33, 4, 5)
        }
        shouldThrow<IllegalArgumentException> {
            LottoGame(11, 22, 33, 4, 5, 6, 7)
        }
    }

    "몇개의 숫자가 일치하는지를 반환해야 한다" {
        val origin = LottoGame(1, 2, 3, 4, 5, 6)
        val target = LottoGame(1, 2, 3, 24, 25, 26)

        origin.numbersIntersections(target) shouldBe 3
    }

    "특정 숫자가 포함되어있는지 여부를 반환 해야 한다" {
        val target = LottoGame(11, 12, 13, 24, 25, 26)

        target.containNumber(LottoNumber(1)) shouldBe false
        target.containNumber(LottoNumber(11)) shouldBe true
        target.containNumber(LottoNumber(13)) shouldBe true
        target.containNumber(LottoNumber(14)) shouldBe false
        target.containNumber(LottoNumber(26)) shouldBe true
    }
})
