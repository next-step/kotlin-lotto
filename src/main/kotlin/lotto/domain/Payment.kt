package lotto.domain

data class Payment(
    val money: Int,
    private val lottoType: LottoType = LottoType.AUTO
)
