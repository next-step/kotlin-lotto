package domain

class LottoNumbers(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == SIZE)
    }

    constructor(numbers: List<LottoNumber>) : this(numbers.toSet())

    constructor(n1: Int, n2: Int, n3: Int, n4: Int, n5: Int, n6: Int) : this(
        listOf(n1, n2, n3, n4, n5, n6).map { LottoNumber(it) }
    )

    companion object {
        private const val SIZE = 6
    }
}
