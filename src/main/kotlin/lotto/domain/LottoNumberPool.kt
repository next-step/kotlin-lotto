package lotto.domain

object LottoNumberPool {
    private val pool: List<LottoNumber> = (1..45).map { LottoNumber(it) }

    fun get(number: Int): LottoNumber {
        require(number in 1..45) { "로또 숫자는 1에서 45 사이입니다." }
        return pool[number - 1]
    }

    fun getRandomNumbers(): List<LottoNumber> {
        return pool.shuffled().take(6).sortedBy { it.value }
    }
}
