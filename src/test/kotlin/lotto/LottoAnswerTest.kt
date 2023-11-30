package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoAnswer
import lotto.domain.MatchCount

class LottoAnswerTest : StringSpec({

    "정답지와 3개가 일치하는 로또가 1개만 존재할 경우 { 3 : 1 } 결과가 나와야 한다" {
        val bonusNumber = 0
        val answer = LottoAnswer.create(listOf(1, 2, 3, 4, 5, 6), bonusNumber)
        val inputLotto = Lotto.create(TestNumberGenerator)
        answer.match(listOf(inputLotto)) shouldBe mapOf(MatchCount.THREE to 1)
    }

    "정답지와 5개가 일치하고 보너스 번호가 일치하는 로또가 존재할 경우 { FIVE_WITH_BONUS : 1} 결과가 나와야 한다" {
        val bonusNumber = 7
        val answer = LottoAnswer.create(listOf(1, 2, 3, 4, 5, 6), bonusNumber)
        val inputLotto = Lotto.create(TestNumberGeneratorFive)
        answer.match(listOf(inputLotto)) shouldBe mapOf( MatchCount.FIVE_WITH_BONUS to 1)
    }
})
