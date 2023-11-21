package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTicketTest : FunSpec({

    context("로또티켓 정상 생성") {
        test("기본 생성자 사용") {
            val lottoNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6)
            val lottoTicket = LottoTicket(lottoNumbers = lottoNumbers)

            lottoTicket.lottoNumbers shouldBe LottoNumbers.of(1, 2, 3, 4, 5, 6)
        }
    }
})
