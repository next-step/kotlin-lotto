package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoAnswer

class LottoAnswerTest : StringSpec({

    "정답지와 3개가 일치하는 로또가 1개만 존재할 경우 { 3 : 1 } 결과가 나와야 한다" {
        val answer = LottoAnswer.create(listOf(1, 2, 3, 4, 5, 6))
        val inputLotto = Lotto.create(TestNumberGenerator)
        answer.match(listOf(inputLotto)) shouldBe mapOf(3 to 1)
    }
})
