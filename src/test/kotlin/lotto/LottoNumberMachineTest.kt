package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeSorted
import io.kotest.matchers.collections.shouldHaveSize

class LottoNumberMachineTest : StringSpec({

    "로또 기계 무작위 번호를 생성하고" {
        val numbers = LottoNumberMachine.generate()

        "생성된 번호는 6개이다" {
            numbers.shouldHaveSize(6)
        }

        "생성된 번호는 모두 다른 번호이다" {
            numbers.distinct().shouldHaveSize(6)
        }

        "생성된 번호는 오름차순으로 정렬되어 있다" {
            numbers.shouldBeSorted()
        }
    }
})
