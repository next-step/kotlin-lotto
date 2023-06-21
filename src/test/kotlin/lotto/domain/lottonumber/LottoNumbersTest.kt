package lotto.domain.lottonumber

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoNumbersTest : BehaviorSpec({

    Given("로또 번호 목록의 사이즈가 6이 아니면") {
        forAll(
            row(5),
            row(7),
        ) { pickCount ->
            Then("RuntimeException 예외 처리를 한다") {
                shouldThrow<RuntimeException> {
                    LottoNumbers(LottoNumber.allLottoNumbers().take(pickCount))
                }
            }
        }
    }

    Given("로또 번호 목록에 중복이 존재하면") {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) }
        Then("RuntimeException 예외 처리를 한다") {
            shouldThrow<RuntimeException> {
                LottoNumbers(lottoNumbers)
            }
        }
    }

    Given("다른 로또 번호와 비교하면") {
        val lottoNumbers = lottoNumbers(1, 2, 3, 4, 5, 6)
        forAll(
            row(lottoNumbers(1, 2, 3, 4, 5, 6), 6),
            row(lottoNumbers(1, 2, 3, 4, 5, 7), 5),
            row(lottoNumbers(1, 2, 3, 4, 7, 8), 4),
            row(lottoNumbers(1, 2, 3, 7, 8, 9), 3),
            row(lottoNumbers(1, 2, 7, 8, 9, 10), 2),
            row(lottoNumbers(1, 7, 8, 9, 10, 11), 1),
            row(lottoNumbers(7, 8, 9, 10, 11, 12), 0),
        ) { other, expectedSize ->
            Then("일치 개수를 반환한다") {
                lottoNumbers.matchCount(other) shouldBe expectedSize
            }
        }
    }
})
