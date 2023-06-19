package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe

class LottoDispenserTest : BehaviorSpec({

    given("로또 자동 구매 시") {
        then("로또가 반환 된다.") {
            val lotto: Lotto = LottoDispenser.auto()
            lotto shouldNotBe null
        }
    }

    given("로또 수동 구매 시") {
        `when`("로또 숫자가 6개 미만이면") {
            then("에러가 발생 한다.") {
                val lottoNumbers = (1..5).map { LottoNumber(it) }
                shouldThrow<RuntimeException> { LottoDispenser.manual(lottoNumbers) }
            }
        }

        `when`("로또 숫자가 7개 이상이면") {
            then("에러가 발생 한다.") {
                val lottoNumbers = (1..7).map { LottoNumber(it) }
                shouldThrow<RuntimeException> { LottoDispenser.manual(lottoNumbers) }
            }
        }

        `when`("로또 숫자가 6개지만 중복이 존재하면") {
            then("에러가 발생 한다.") {
                val lottoNumbers = listOf(1, 1, 3, 4, 5, 6).map { LottoNumber(it) }
                shouldThrow<RuntimeException> { LottoDispenser.manual(lottoNumbers) }
            }
        }
    }
})
