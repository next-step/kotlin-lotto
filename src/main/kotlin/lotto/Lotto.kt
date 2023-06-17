package lotto

class Lotto(
    val lottoNumbers: Set<Int>,
) {
    init {
        require(lottoNumbers.size == 6) { "로또 번호는 중복 없이 6개만 입력 가능합니다." }
        require(lottoNumbers.all { it in 1..45 }) { "로또 번호는 1~45 사이만 입력 가능합니다." }
    }

    fun countMatchingNumbersFrom(winningNumbers: List<Int>): Int {
        var count = 0

        winningNumbers.forEach { winningNumber ->
            if (lottoNumbers.contains(winningNumber)) count++
        }

        return count
    }

    companion object {
        fun from(numbers: Collection<Int>): Lotto {
            return Lotto(numbers.toSet())
        }
    }
}
