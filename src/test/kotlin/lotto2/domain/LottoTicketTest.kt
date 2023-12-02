package lotto2.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class IsNumberMatchedTest : StringSpec({
    val lottoTicket = LottoTicket(LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }))

    "로또 티켓에 있는 번호 중에 포함된 숫자라면 참을 반환한다." {
        lottoTicket.isNumberMatched(LottoNumber(1)) shouldBe true
        lottoTicket.isNumberMatched(LottoNumber(2)) shouldBe true
        lottoTicket.isNumberMatched(LottoNumber(3)) shouldBe true
        lottoTicket.isNumberMatched(LottoNumber(4)) shouldBe true
        lottoTicket.isNumberMatched(LottoNumber(5)) shouldBe true
        lottoTicket.isNumberMatched(LottoNumber(6)) shouldBe true
    }

    "로또 티켓에 있는 번호 중에 포함된 숫자가 아니라면 거짓을 반환한다." {
        lottoTicket.isNumberMatched(LottoNumber(23)) shouldBe false
        lottoTicket.isNumberMatched(LottoNumber(34)) shouldBe false
        lottoTicket.isNumberMatched(LottoNumber(44)) shouldBe false
        lottoTicket.isNumberMatched(LottoNumber(45)) shouldBe false
    }
})
