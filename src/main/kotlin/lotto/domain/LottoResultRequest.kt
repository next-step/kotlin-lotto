package lotto.domain

class LottoResultRequest(
    val payment: Int,
    val luckyNumbers: List<Int>,
    val lottoList: List<Lotto>
)
