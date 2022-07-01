package lotto.domain

data class LottoResult(
    val lottoPrize: LottoPrize,
    val matchedLottoCount: PositiveNumber
) {
    constructor(lottoResult: Map.Entry<LottoPrize, Int>) :
        this(lottoResult.key, PositiveNumber(lottoResult.value))
}
