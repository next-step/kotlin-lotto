package lotto.domain

data class LottoCount(val value: Int?) {
    init {
        require(value != null) { "로또 수량의 값은 숫자이어야 합니다." }
        require(value >= MIN_LOTTO_COUNT) { "로또 수량의 값은 최소 0이어야 합니다. value=$value" }
    }

    constructor(price: Price) : this(
        (price.value ?: 0) / LottoNumbers.LOTTO_PRICE
    )

    operator fun minus(other: LottoCount): LottoCount {
        return LottoCount(value?.minus(other.value!!))
    }

    companion object {
        private const val MIN_LOTTO_COUNT = 0
    }
}
