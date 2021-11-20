package lotto.domain

data class LottoNumber(
    val numbers: List<Int> = Lotto.allNumber.shuffled().subList(0, 6).sorted()
)
