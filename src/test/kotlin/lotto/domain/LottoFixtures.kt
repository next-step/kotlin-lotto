package lotto.domain

fun `기본 로또 번호 목록(1~6)`() = createLottoNumbers(1..6)
fun `기본 로또 티켓(1~6)`() = LottoTicket(`기본 로또 번호 목록(1~6)`())
fun `로또 티켓`(intRange: IntRange): LottoTicket {
    return LottoTicket(createLottoNumbers(intRange))
}

private fun createLottoNumbers(intRange: IntRange): List<LottoNumber> {
    return intRange.map(::LottoNumber)
}
