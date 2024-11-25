package lotto.domain

sealed class Lotto(
    val numbers: Set<LottoNumber>,
) {
    init {
        require(numbers.size == LOTTO_SIZE) { "로또는 6개의 숫자를 가져야 합니다." }
    }

    abstract fun compare(lotto: Lotto): Result

    companion object {
        private const val LOTTO_SIZE = 6
    }
}

class DefaultLotto(
    numbers: Set<LottoNumber>,
) : Lotto(numbers) {
    val sortedNumbers: List<Int> = numbers.map(LottoNumber::value).sorted()

    override fun compare(lotto: Lotto): Result {
        val count = lotto.numbers.count(numbers::contains)
        return Result.of(count)
    }
}

class WinningLotto(
    numbers: Set<LottoNumber>,
    private val bonusNumber: LottoNumber,
) : Lotto(numbers) {
    init {
        require(!numbers.contains(bonusNumber)) { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }

    override fun compare(lotto: Lotto): Result {
        val count = lotto.numbers.count(numbers::contains)
        val matchBonus = lotto.numbers.contains(bonusNumber)
        return Result.of(count, matchBonus)
    }
}
