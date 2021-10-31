package lotto.domain

@JvmInline
value class LottoNumber(private val numbers: List<Int> = LottoNumberGenerator().generateRandomNumber()) {

    fun toList(): List<Int> = numbers.toList()

    init {
        val size = numbers.size
        require(size == 6) { "숫자가 6개가 들어와야 합니다." }
        require(numbers.distinct().size == size) { "중복 된 숫자는 들어올 수 없습니다." }
    }
}
