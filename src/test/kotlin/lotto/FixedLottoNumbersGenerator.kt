package lotto

class FixedLottoNumbersGenerator(private val numbers: List<Set<Int>>) : LottoNumbersGenerator {
    private var index = 0

    override fun generate(): Set<Int> {
        require(index < numbers.size) { "더 이상 사용할 수 있는 로또 번호가 없습니다." }
        return numbers[index++]
    }
}
