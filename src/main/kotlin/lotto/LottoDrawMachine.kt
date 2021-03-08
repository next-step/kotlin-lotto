package lotto

class LottoDrawMachine(private val pool: Set<Int>) {
    val size: Int = pool.size

    init {
        require(size == POOL_SIZE)
    }

    constructor(range: IntRange) : this(range.toSet())

    fun lottoNumber(): LottoNumber = pool.shuffled()
        .toSet()
        .let { LottoNumber.from(it) }

    companion object {
        const val POOL_SIZE: Int = 45
    }
}
