package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoCountTest : StringSpec({

    "로또 개수가 0개 미만이면 예외가 발생한다." {
        // given
        val count = -1

        // expected
        shouldThrowWithMessage<IllegalArgumentException>("로또 개수는 0개 이상이어야 합니다.") {
            LottoCount(count)
        }
    }

    "입력받은 값을 곱한다" {
        // given
        val other = 2000
        val lottoCount = LottoCount(10)

        // when
        val result = lottoCount.multiply(other)

        // then
        result shouldBe 20000
    }

    "입력받은 값을 더한다" {
        // given
        val other = LottoCount(3)
        val lottoCount = LottoCount(11)

        // when
        val result = lottoCount.plus(other)

        // then
        result shouldBe LottoCount(14)
    }
})
