package lottery.domain

interface LottoNumberGenerator {
    fun getNumbers(): List<Int>
}
