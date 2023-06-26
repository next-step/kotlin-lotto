package lotto

object AutoLottoFactory {
    fun create(salePrice: Int) =
        Lotto(numbers = createLottoNumbers(), salePrice, LottoType.AUTO)

    private fun createLottoNumbers() = LottoNumbers((1..45).shuffled().subList(0, 6).sorted().map { LottoNumber(it) })
}
