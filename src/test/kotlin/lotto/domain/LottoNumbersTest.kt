package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest : BehaviorSpec({

    given("로또 번호 리스트(1,2,3,4,5,6)이고 당첨번호 리스트(1,2,3,4,5,7) 일때.") {
        val lottoNumbers = LottoNumbers(
            listOf(1, 2, 3, 4, 5, 6)
                .map { LottoNumber(it) }
        )
        val otherNumbers = LottoNumbers(
            listOf(1, 2, 3, 4, 5, 7)
                .map { LottoNumber(it) }
        )
        `when`("로또 번호를 당첨 번호 리스트를 비교한다면") {
            val matchCount = lottoNumbers.matchNumbersCount(otherNumbers)
            then("5개가 일치한다.") {
                matchCount shouldBe 5
            }
        }
    }

    given("로또 번호 리스트(1,2,3,4,5,6)이고 보너스 번호가 7일때") {
        val lottoNumbers = LottoNumbers(
            listOf(1, 2, 3, 4, 5, 6)
                .map { LottoNumber(it) }
        )
        val bonusNumber = LottoNumber(7)
        `when`("로또 번호를 보너스 번호와 비교한다면") {
            val matchCount = lottoNumbers.matchNumbers(bonusNumber)
            then("false 반환한다.") {
                matchCount shouldBe false
            }
        }
    }

    given("주어진 로또의 숫자가") {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) }
        `when`("중복일때") {
            val exception = shouldThrow<IllegalArgumentException> {
                LottoNumbers(listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) })
            }
            then("예외가 발생한다.") {
                exception.message shouldBe "로또는 중복되지 않는 숫자만 가질 수 있습니다."
            }
        }
    }
})
