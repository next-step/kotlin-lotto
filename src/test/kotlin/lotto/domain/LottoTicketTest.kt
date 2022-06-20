package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class LottoTicketTest : FreeSpec({

    "당첨 번호와 보너스 번호가 중복될 경우 예외가 발생한다." {
        // given
        val lottoNumbers = LottoNumbers.createWithSort(
            listOf(1, 2, 3, 4, 5, 6)
                .map { LottoNumber.from(it) }
                .toSet()
        )

        // when
        val exception = shouldThrowExactly<IllegalArgumentException> {
            LottoTicket(
                lottoNumbers = lottoNumbers,
                bonusNumber = LottoNumber.from(1)
            )
        }

        // then
        exception.message shouldBe "보너스 번호는 당첨 번호들과 중복될 수 없습니다."
    }
})
