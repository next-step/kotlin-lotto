package lotto.domain

import io.kotest.matchers.equals.shouldBeEqual
import lotto.domain.LottoTicket.AutoLottoTicket
import lotto.domain.LottoTicket.ManualLottoTicket
import lotto.util.createLottoNumbers
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoTicketTest {
    @MethodSource("구매한 로또의 번호, 당첨 번호, 매칭 결과 제공")
    @ParameterizedTest
    fun `당첨 번호를 토대로 몇 등 인지 확인 할 수 있다`(
        lottoTicket: LottoTicket,
        lottoWinnerNumbers: LottoWinnerNumbers,
        lottoWinnerRank: LottoWinnerRank,
    ) {
        lottoTicket.checkLottoWinnerRank(lottoWinnerNumbers) shouldBeEqual lottoWinnerRank
    }

    fun `구매한 로또의 번호, 당첨 번호, 매칭 결과 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                ManualLottoTicket(createLottoNumbers(1, 2, 3, 4, 5, 6)),
                LottoWinnerNumbers(createLottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.of(7)),
                LottoWinnerRank.FIRST,
            ),
            Arguments.of(
                ManualLottoTicket(createLottoNumbers(1, 2, 3, 4, 5, 6)),
                LottoWinnerNumbers(createLottoNumbers(1, 2, 3, 4, 5, 7), LottoNumber.of(6)),
                LottoWinnerRank.SECOND,
            ),
            Arguments.of(
                AutoLottoTicket { createLottoNumbers(1, 2, 3, 4, 5, 6) },
                LottoWinnerNumbers(createLottoNumbers(1, 2, 3, 4, 5, 8), LottoNumber.of(7)),
                LottoWinnerRank.THIRD,
            ),
            Arguments.of(
                ManualLottoTicket(createLottoNumbers(1, 2, 3, 4, 5, 6)),
                LottoWinnerNumbers(createLottoNumbers(1, 2, 3, 4, 8, 9), LottoNumber.of(7)),
                LottoWinnerRank.FOURTH,
            ),
            Arguments.of(
                AutoLottoTicket { createLottoNumbers(1, 2, 3, 4, 5, 6) },
                LottoWinnerNumbers(createLottoNumbers(1, 2, 3, 8, 9, 10), LottoNumber.of(7)),
                LottoWinnerRank.FIFTH,
            ),
            Arguments.of(
                ManualLottoTicket(createLottoNumbers(1, 2, 3, 4, 5, 6)),
                LottoWinnerNumbers(createLottoNumbers(1, 2, 8, 9, 10, 11), LottoNumber.of(7)),
                LottoWinnerRank.MISS,
            ),
            Arguments.of(
                AutoLottoTicket { createLottoNumbers(1, 2, 3, 4, 5, 6) },
                LottoWinnerNumbers(createLottoNumbers(1, 8, 9, 10, 11, 12), LottoNumber.of(7)),
                LottoWinnerRank.MISS,
            ),
            Arguments.of(
                ManualLottoTicket(createLottoNumbers(1, 2, 3, 4, 5, 6)),
                LottoWinnerNumbers(createLottoNumbers(8, 9, 10, 11, 12, 13), LottoNumber.of(7)),
                LottoWinnerRank.MISS,
            ),
        )
    }
}
