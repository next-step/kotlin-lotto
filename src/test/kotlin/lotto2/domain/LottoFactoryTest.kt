package lotto2.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoFactoryTest : StringSpec({

    "5개의 티켓 수량이 주어지면, 5개의 로또 티켓을 생성하여 반환한다." {
        val 티켓수량 = 5
        val 로또티켓목록 = LottoFactory.generate(티켓수량)

        로또티켓목록.size shouldBe 티켓수량
    }

    "6개의 로또 번호를 가진 수동 로또번호가 주어지면, 해당 번호를 그대로 가진 로또 티켓을 생성하여 반환한다." {
        val 로또번호 = listOf(LottoNumbers(listOf(45, 44, 43, 42, 41, 40).map { LottoNumber(it) }))
        val 로또티켓목록 = LottoFactory.generate(로또번호)

        로또티켓목록[0].isNumberMatched(LottoNumber(45)) shouldBe true
        로또티켓목록[0].isNumberMatched(LottoNumber(44)) shouldBe true
        로또티켓목록[0].isNumberMatched(LottoNumber(43)) shouldBe true
        로또티켓목록[0].isNumberMatched(LottoNumber(42)) shouldBe true
        로또티켓목록[0].isNumberMatched(LottoNumber(41)) shouldBe true
        로또티켓목록[0].isNumberMatched(LottoNumber(7)) shouldBe false
    }
})
