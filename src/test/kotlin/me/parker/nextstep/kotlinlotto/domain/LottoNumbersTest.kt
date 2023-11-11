package me.parker.nextstep.kotlinlotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest : DescribeSpec({

    describe("add 메서드") {
        context("LottoNumbers 내부의 로또 번호 개수가 6개 미만인 경우") {
            it("LottoNumbers에 정상적으로 추가된다.") {
                val lottoNumbers = LottoNumbers()

                lottoNumbers.values.size shouldBe 0

                var expectedSize = 1
                for (num in 1..6) {
                    val lottoNumber = LottoNumber(num)
                    lottoNumbers.add(lottoNumber)
                    lottoNumbers.values.size shouldBe expectedSize++
                }
            }
        }

        context("이미 가지고 있는 번호를 추가하려고 하면") {
            it("예외는 발생하지 않고, 개수 변화가 없다.") {
                val lottoNumbers = LottoNumbers()

                lottoNumbers.add(LottoNumber(1))
                lottoNumbers.values.size shouldBe 1

                lottoNumbers.add(LottoNumber(1))
                lottoNumbers.values.size shouldBe 1
            }
        }
    }
})
