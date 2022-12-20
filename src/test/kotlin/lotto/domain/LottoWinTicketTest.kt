package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoWinTicketTest : FunSpec({

    context("LottoWinTicket 생성") {
        test("fun from()") {
            shouldNotThrowAny {
                LottoWinTicket.from("1,2,3,4,5,6", "13")
            }

            shouldThrowExactly<IllegalArgumentException> {
                LottoWinTicket.from("1,2,3,4,5,6", "1")
            }
        }
    }

    context("LottoWinTicket 메소드") {
        val lottoWinTicket = LottoWinTicket.from("1,2,3,4,5,6", "13")

        test("matches") {
            with(lottoWinTicket) {
                matches(LottoNumbers.from("1,2,3,4,5,6")) shouldBe LottoReward.FIRST
                matches(LottoNumbers.from("13,2,3,4,5,6")) shouldBe LottoReward.SECOND
                matches(LottoNumbers.from("7,2,3,4,5,6")) shouldBe LottoReward.THIRD
                matches(LottoNumbers.from("7,8,3,4,5,6")) shouldBe LottoReward.FIRTH
                matches(LottoNumbers.from("7,8,9,4,5,6")) shouldBe LottoReward.FIFTH
                matches(LottoNumbers.from("7,8,9,10,5,6")) shouldBe LottoReward.FAIL
                matches(LottoNumbers.from("7,8,9,10,11,6")) shouldBe LottoReward.FAIL
                matches(LottoNumbers.from("7,8,9,10,11,12")) shouldBe LottoReward.FAIL
            }
        }
    }
})
