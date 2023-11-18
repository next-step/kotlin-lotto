package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoCountTest : StringSpec({

    "로또 개수가 0개 미만이면 실패를 반환한다." {
        // given
        val count = -1

        // when
        val result = LottoCount.createResult(count)

        // then
        result shouldBe LottoCountResult.Failure("로또 개수는 0개 이상이어야 합니다.")
    }

    "입력받은 값을 곱한다" {
        // given
        val other = 2000
        val lottoCount = LottoCount.from(10)

        // when
        val result = lottoCount.multiply(other)

        // then
        result shouldBe 20000
    }

    "입력받은 값을 더한다" {
        // given
        val other = LottoCount.from(3)
        val lottoCount = LottoCount.from(11)

        // when
        val result = lottoCount.plus(other)

        // then
        result shouldBe LottoCount.from(14)
    }

    "개수가 0개면 true, 아니면 false를 반환한다." {
        forAll(
            row(0, true),
            row(1, false)
        ) { count, expected ->
            // given
            val lottoCount = LottoCount.from(count)

            // when
            val actual = lottoCount.isZero()

            // then
            actual shouldBe expected
        }
    }
})
