package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoNumberGeneratorTest : BehaviorSpec({

    given("로또 번호 범위가 주어졌을 때.") {
        val lottoNumbers = (1..6).map { LottoNumber(it) }

        `when`("로또 번호를 생성한다.") {
            val lottoNumberGenerator = LottoNumberGenerator { lottoNumbers }
                .takeShuffleNumber(lottoNumbers)
            then("생성된 로또번호를 확인한다.") {
                lottoNumberGenerator.numbers shouldBe lottoNumbers
            }
        }
    }
})
