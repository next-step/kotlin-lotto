package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : BehaviorSpec({

    given("당첨번호가 1,2,3,4,5,6일때 보너스 번호가 6으로 주어지면") {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val bonusNumber = LottoNumber(6)
        `when`("당첨 로또를 생성할 때") {
            val exception = shouldThrow<IllegalArgumentException> {
                WinningLotto(lottoNumbers, bonusNumber)
            }
            then("예외가 발생한다.") {
                exception.message shouldBe "보너스 볼은 당첨 번호와 중복될 수 없습니다."
            }
        }
    }

    given("로또 번호와 당첨번호, 보너스 번호가 주어졌을 때") {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winningLottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 7).map { LottoNumber(it) })
        val winningLotto = WinningLotto(winningLottoNumbers, LottoNumber(6))
        `when`("로또 번호를 당첨 번호 리스트를 비교한다면") {
            val result = winningLotto.match(lottoNumbers)
            then("5개가 일치하고 보너스 번호도 일치한다.") {
                result.first shouldBe 5
                result.second shouldBe true
            }
        }
    }
})
