package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe

class LottoNumbersTest : BehaviorSpec({
    Given("로또를 한번 구매할 때마다") {
        val lottoNumbers = LottoNumbers()
        When("LottoNumbers 는") {
            val lotto = lottoNumbers.generate()
            Then("6개의 서로 다른 숫자가 담긴 로또를 하나 발급한다.") {
                lotto.numbers.size shouldBe Lotto.LOTTO_COUNT
            }
        }
    }

    Given("로또를 구매하면") {
        val lottoNumbers = LottoNumbers()
        When("LottoNumbers 는") {
            val lotto = lottoNumbers.generate()
            Then("오름차순으로 정렬된 로또를 발급한다.") {
                val lottoNumber1 = lotto.numbers[0]
                val lottoNumber2 = lotto.numbers[1]
                val lottoNumber3 = lotto.numbers[2]
                val lottoNumber4 = lotto.numbers[3]
                val lottoNumber5 = lotto.numbers[4]
                val lottoNumber6 = lotto.numbers[5]

                lottoNumber1.value shouldBeLessThan lottoNumber2.value
                lottoNumber2.value shouldBeLessThan lottoNumber3.value
                lottoNumber3.value shouldBeLessThan lottoNumber4.value
                lottoNumber4.value shouldBeLessThan lottoNumber5.value
                lottoNumber5.value shouldBeLessThan lottoNumber6.value
            }
        }
    }
})
