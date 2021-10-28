package lotto.model

class Lotto(
    val price: Int,
    private val numbers: LottoNumbers
) {

    init {
        require(price >= 0)
    }
}
