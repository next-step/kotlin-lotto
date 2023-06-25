package lotto.domain.response

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import lotto.domain.Money
import lotto.domain.extension.lottoNumbers

class LottosGenerateRequestSpec : DescribeSpec({
    describe("객체 생성 검증") {
        context("로또 비용(2000원)이 수동 로또 번호(1개)보다 많으면") {
            val money = Money(2000)
            val manualLottoNumbers = listOf(
                lottoNumbers(1, 2, 3, 4, 5, 6),
            )

            it("객체가 생성된다.") {
                LottosGenerateRequest(money, manualLottoNumbers)
            }
        }

        context("로또 비용(2000원)이 수동 로또 번호(2개)와 같으면") {
            val money = Money(2000)
            val manualLottoNumbers = listOf(
                lottoNumbers(1, 2, 3, 4, 5, 6),
                lottoNumbers(1, 2, 3, 4, 5, 7),
            )

            it("객체가 생성된다.") {
                LottosGenerateRequest(money, manualLottoNumbers)
            }
        }

        context("로또 비용(1000원)보다 구매하려는 수동 로또 번호(2개)가 더 많으면") {
            val money = Money(1000)
            val manualLottoNumbers = listOf(
                lottoNumbers(1, 2, 3, 4, 5, 6),
                lottoNumbers(1, 2, 3, 4, 5, 7),
            )

            it("예외가 발생한다. (로또를 구매할 수 없다.)") {
                shouldThrowExactly<IllegalArgumentException> {
                    LottosGenerateRequest(money, manualLottoNumbers)
                }
            }
        }
    }
})
