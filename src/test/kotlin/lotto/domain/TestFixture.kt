package lotto.domain

import lotto.domain.lottoticket.LottoNumber
import lotto.domain.lottoticket.LottoNumbers
import lotto.domain.lottoticket.LottoTicket

fun LottoNumbers(numberSet: Set<Int>): LottoNumbers = LottoNumbers.createWithSort(
    numberSet.map(LottoNumber.Companion::from)
        .toSet()
)

fun LottoTicket(
    n1: Int,
    n2: Int,
    n3: Int,
    n4: Int,
    n5: Int,
    n6: Int
): LottoTicket {
    val lottoNumberSet = listOf(n1, n2, n3, n4, n5, n6)
        .map { LottoNumber.from(it) }
        .toSet()

    return LottoTicket(
        lottoNumbers = LottoNumbers.createWithSort(lottoNumberSet)
    )
}
