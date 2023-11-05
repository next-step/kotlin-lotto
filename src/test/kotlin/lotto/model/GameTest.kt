package lotto.model

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.LottoFixture

class GameTest : StringSpec({
    "6개의 숫자만을 가져야한다" {
        shouldNotThrow<IllegalArgumentException> {
            LottoFixture.gameOf(11, 22, 33, 4, 5, 6)
        }
    }

    "6개보다 부족하거나, 초과하면 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            LottoFixture.gameOf(11, 22, 33, 4, 5)
        }

        shouldThrow<IllegalArgumentException> {
            LottoFixture.gameOf(11, 22, 33, 4, 5, 6, 7)
        }
    }

    "포함하는 6개의 lottoNumbers 는 오름차순으로 정렬되어있어야 한다" {
        val actual = LottoFixture.gameOf(11, 27, 22, 33, 35, 4)
        actual shouldBe LottoFixture.gameOf(4, 11, 22, 27, 33, 35)
        actual.lottoNumbers shouldBe LinkedHashSet(
            listOf(4, 11, 22, 27, 33, 35)
                .map { LottoNumber(it) }
        )
    }
})
