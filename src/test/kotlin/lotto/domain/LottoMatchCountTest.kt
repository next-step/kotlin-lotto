package lotto.domain

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class LottoMatchCountTest : DescribeSpec({

    describe("constructor") {
        context("숫자 하나가 주어졌을 때") {
            it("숫자가 0~6 사이 이면 일치 숫자를 생성한다") {
                listOf(0, 1, 2, 3, 4, 5, 6).forAll {
                    LottoMatchCount(it) shouldNotBe null
                }
            }

            it("숫자 목록이 0~6 사이가 아니면 IllegalArgumentException 이 발생한다") {
                listOf(-1, 7).forAll {
                    shouldThrow<IllegalArgumentException> { LottoMatchCount(it) }
                }
            }
        }

        context("숫자 목록이 주어졌을 때") {
            it("숫자가 0~6 사이 이면 일치 숫자를 생성한다") {
                LottoMatchCount.listOf(0, 1, 2, 3, 4, 5, 6) shouldNotBe null
            }
        }
    }

    describe("equals") {
        it("두 일치 개수를 비교할 수 있다.") {
            assertSoftly {
                LottoMatchCount(1) shouldBe LottoMatchCount(1)
                LottoMatchCount(1) shouldNotBe LottoMatchCount(2)
            }
        }
    }
})
