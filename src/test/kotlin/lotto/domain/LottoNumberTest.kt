package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.shouldBe

class LottoNumberTest: BehaviorSpec({
    given("로또 번호 생성 시") {
        `when`("1보다 작은 숫자면") {
            then("생성에 실패 한다.") {
                shouldThrow<Exception> { LottoNumber(-1) }
            }
        }
        `when`("45보다 큰 숫자면") {
            then("생성에 실패 한다.") {
                shouldThrow<Exception> { LottoNumber(46) }
            }
        }
        `when`("범위(1~45) 내의 숫자면") {
            then("생성에 성공 한다.") {
                shouldNotThrow<Exception> { LottoNumber(1) }
                shouldNotThrow<Exception> { LottoNumber(45) }
            }
        }
    }

    given("로또 번호는") {
        `when`("같은 숫자면") {
            val lottoNumberA = LottoNumber(10)
            val lottoNumberB = LottoNumber(10)
            then("동일 하다.(equals)") {
                lottoNumberA shouldBeEqualComparingTo lottoNumberB
            }
            then("중복이 제거 된다.(distinct)") {
                val distincted = listOf(lottoNumberA, lottoNumberB).distinct()
                distincted.size shouldBe 1
                distincted[0] shouldBe LottoNumber(10)
            }
        }
        `when`("여러 개의 번호가 있을 떄") {
            val lottoNumbers = listOf(
                LottoNumber(30),
                LottoNumber(10),
                LottoNumber(40),
                LottoNumber(20),
            )
            then("정렬이 가능 하다. (sort)") {
                val sortedLottoNumbers = lottoNumbers.sorted()
                sortedLottoNumbers[0] shouldBe LottoNumber(10)
                sortedLottoNumbers[1] shouldBe LottoNumber(20)
                sortedLottoNumbers[2] shouldBe LottoNumber(30)
                sortedLottoNumbers[3] shouldBe LottoNumber(40)

            }
        }
    }
})
