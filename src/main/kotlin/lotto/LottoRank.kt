package lotto

enum class LottoRank(val sameCount: Int, val price: Int) {
    FOURTH(sameCount = 3, price = 5000),
    THIRD(sameCount = 4, price = 50_000),
    SECOND(sameCount = 5, price = 1_500_000),
    FIRST(sameCount = 6, price = 2_000_000_000)
}
