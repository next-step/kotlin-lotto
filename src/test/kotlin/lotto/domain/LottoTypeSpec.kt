package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import lotto.domain.extension.lottoNumbers

class LottoTypeSpec : DescribeSpec({
    describe("자동 로또 생성 검증") {
        context("로또 수량(3개)이 주어지면") {
            val lottoQuantity = LottoQuantity(3)

            it("자동으로 로또(3개)를 생성한다.") {
                val lottos = LottoType.AUTO.generate(lottoQuantity)

                lottos.lottoQuantity.value shouldBe 3
            }
        }
    }

    describe("수동 로또 생성 검증") {
        context("로또 수량(3개)와 로또 번호(3개)가 주어지면") {
            val lottoQuantity = LottoQuantity(3)
            val lottoNumbers = listOf(
                lottoNumbers(1, 2, 3, 4, 5, 6),
                lottoNumbers(1, 2, 3, 4, 5, 7),
                lottoNumbers(1, 2, 3, 4, 5, 8),
            )

            it("수동으로 로또(3개)를 생성한다.") {
                val lottos = LottoType.MANUAL.generate(lottoQuantity, lottoNumbers)

                lottos.lottoQuantity.value shouldBe 3
                lottos.values.forEach { lotto ->
                    lotto.numbers shouldBeIn lottoNumbers
                }
            }
        }
    }
})
