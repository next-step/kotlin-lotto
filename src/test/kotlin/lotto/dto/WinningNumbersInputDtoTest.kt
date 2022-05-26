package lotto.dto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class WinningNumbersInputDtoTest : DescribeSpec({
    it(", 로 나누어서 로또 번호로 저장합니다") {
        // given
        val winningNumbersString = "1, 2, 3, 4, 5, 6"

        // when
        val winningNumbersInputDto = WinningNumbersInputDto(winningNumbersString)

        // then
        winningNumbersInputDto.winningLottoTicketNumbers.value.size shouldBe 6
        winningNumbersInputDto.winningLottoTicketNumbers.value.map { it.value } shouldContainAll listOf(
            1,
            2,
            3,
            4,
            5,
            6
        )
    }
})
