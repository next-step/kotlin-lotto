package lotto

data class LottoNumber(val numbers: List<Int>) {
    init {
        require(numbers.size == LottoConst.maxCount) { "로또 번호 중복 또는 개수가 잘 못 되었습니다." }
        require(numbers.min()!! >= LottoConst.startNumber) { "최소 번호가 잘 못 되었습니다." }
        require(numbers.max()!! <= LottoConst.endNumber) { "최대 번호가 잘 못 되었습니다." }
    }
}
