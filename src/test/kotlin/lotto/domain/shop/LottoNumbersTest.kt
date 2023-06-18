package lotto.domain.shop

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row

class LottoNumbersTest : BehaviorSpec({

    Given("로또 게임을 생성할 때") {
        When("로또 번호 목록의 사이즈가 6이 아니면") {
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

        Then("중복이 존재하면 RuntimeException 예외 처리를 한다") {
            shouldThrow<RuntimeException> {
                LottoNumbers(listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) })
            }
        }
    }
})
