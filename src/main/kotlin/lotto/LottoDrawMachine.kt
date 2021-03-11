package lotto

class LottoDrawMachine(private val pool: Set<Int>) {
    val size: Int = pool.size

    init {
        require(size == POOL_SIZE)
    }

    constructor(range: IntRange) : this(range.toSet())

    fun lottoNumber(): LottoNumbers = pool.shuffled()
        .toSet()
        .let { LottoNumbers.from(it) }

    companion object {
        const val POOL_SIZE: Int = 45
    }
}
