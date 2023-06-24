package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

class LottoTest : BehaviorSpec({
    given("로또 생성 시") {
        `when`("로또 번호가 5개 입력 되면") {
            val lottoNumbers = listOf(1, 2, 3, 4, 5).map { LottoNumber(it) }
            then("에러가 발생 한다.") {
                shouldThrow<Exception> { Lotto.of(lottoNumbers) }
            }
        }
        `when`("로또 번호가 7개 입력 되면") {
            val lottoNumbers = listOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber(it) }
            then("에러가 발생 한다.") {
                shouldThrow<Exception> { Lotto.of(lottoNumbers) }
            }
        }
        `when`("로또 번호가 6개 이지만 중복이 존재 하면") {
            val lottoNumbers = listOf(1, 2, 3, 4, 6, 6).map { LottoNumber(it) }
            then("에러가 발생 한다.") {
                shouldThrow<Exception> { Lotto.of(lottoNumbers) }
            }
        }
    }
})
