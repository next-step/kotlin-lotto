package lotto

object LottoFactory {
    fun create(salePrice: Int) = Lotto(numbers = (1..45).shuffled().subList(0, 6).sorted(), salePrice)
}
