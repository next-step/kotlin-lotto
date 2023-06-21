package lotto

object LottoFactory {
    fun create(salePrice: Int) =
        Lotto(numbers = createLottoNumbers(), salePrice)

    private fun createLottoNumbers() = (1..45).shuffled().subList(0, 6).sorted().map { LottoNumber(it) }
}
